package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Playlist;
import com.example.mp3.repo.musicRepo.IPlaylistRepository;
import com.example.mp3.service.music.interfaceMusic.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private IPlaylistRepository playlistRepository;

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
}
