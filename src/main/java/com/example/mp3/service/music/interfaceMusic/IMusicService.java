package com.example.mp3.service.music.interfaceMusic;

import com.example.mp3.model.music.Music;
import com.example.mp3.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IMusicService extends IGeneralService<Music> {
    Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album);
    Iterable<Music> findAllByMusicNameContaining(String name);
}
