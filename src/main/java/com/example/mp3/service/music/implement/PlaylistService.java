package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Playlist;
import com.example.mp3.repo.musicRepo.IMusicRepository;
import com.example.mp3.repo.musicRepo.IPlaylistRepository;
import com.example.mp3.service.music.interfaceMusic.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private IPlaylistRepository playlistRepository;
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void remove(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public Playlist addMusicToPlaylist(Long playlistId, Long musicId) {
        Optional<Playlist> playlistOptional = findById(playlistId);
        Optional<Music> musicOptional = musicRepository.findById(musicId);
        if (playlistOptional.isPresent() && musicOptional.isPresent()) {
            Playlist playlist = playlistOptional.get();
            Music music = musicOptional.get();
            playlist.addMusic(music);
            return playlistRepository.save(playlist);
        }
        return null;
    }

    @Override
    public void removeMusicFromPlaylist(Long playlistId, Long musicId) {
        Optional<Playlist> playlistOptional = findById(playlistId);
        Optional<Music> musicOptional = musicRepository.findById(musicId);
        if (playlistOptional.isPresent() && musicOptional.isPresent()){
            musicRepository.deleteById(musicId);
        }
    }
}
