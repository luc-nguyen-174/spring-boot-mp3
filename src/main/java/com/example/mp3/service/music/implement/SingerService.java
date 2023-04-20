package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Singer;
import com.example.mp3.repo.musicRepo.IMusicRepository;
import com.example.mp3.repo.musicRepo.ISingerRepo;
import com.example.mp3.service.music.interfaceMusic.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SingerService implements ISingerService {
    @Autowired
    private ISingerRepo singerRepo;

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Iterable<Singer> findAll() {
        return singerRepo.findAll();
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepo.findById(id);
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepo.save(singer);
    }

    @Override
    public void remove(Long id) {
        singerRepo.deleteById(id);
    }

    @Override
    public Singer findBySingerName(String name) {
        return singerRepo.findBySingerName(name);
    }

    @Override
    public Set<Singer> getBySingerName(Set<String> singerName) {
        Set<Singer> singers = new HashSet<>();

        for (String singerNameS : singerName) {
            Singer singer = singerRepo.findBySingerName(singerNameS);
                singers.add(singer);
        }
        return singers;
    }

    @Override
    public Singer addMusicToSinger(Long singerId, Long musicId) {
        Optional<Singer> singerOptional = findById(singerId);
        Optional<Music> musicOptional = musicRepository.findById(musicId);
        if (singerOptional.isPresent() && musicOptional.isPresent()) {
            Singer singer = singerOptional.get();
            Music music = musicOptional.get();
            singer.addMusic(music);
            return singerRepo.save(singer);
        }
        return null;
    }
}
