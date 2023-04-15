package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Author;
import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Singer;
import com.example.mp3.repo.musicRepo.IMusicRepository;
import com.example.mp3.service.music.interfaceMusic.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

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
    public Iterable<Music> findAllByMusicNameOrSingersOrAuthors(String musicName, Set<Singer> singers, Set<Author> authors) {
        return musicRepository.findAllByMusicNameOrSingersOrAuthors(musicName, singers, authors);
    }
}
