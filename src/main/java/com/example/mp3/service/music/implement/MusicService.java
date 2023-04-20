package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Music;
import com.example.mp3.repo.musicRepo.IMusicRepository;
import com.example.mp3.service.music.interfaceMusic.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void remove(Long id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album) {
        return musicRepository.findAllByAlbumsContainingIgnoreCase(album);
    }

    @Override
    public Iterable<Music> findAllByMusicNameContaining(String name) {
        return musicRepository.findAllByMusicNameContaining(name);
    }


}
