package com.example.mp3.service.music.interfaceMusic;

import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Singer;
import com.example.mp3.service.IGeneralService;


public interface IMusicService extends IGeneralService<Music> {
    Iterable<Music> findAllByMusicNameContainingIgnoreCaseOrSingersContainingIgnoreCaseOrAuthorsNotContainingIgnoreCase(
            String musicName, Singer singers, String authors);
    Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album);
}
