package com.example.mp3.service.music.interfaceMusic;

import com.example.mp3.model.music.Author;
import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Singer;
import com.example.mp3.repo.musicRepo.IMusicRepository;
import com.example.mp3.service.IGeneralService;

import java.util.Set;

public interface IMusicService extends IGeneralService<Music> {
    Iterable<Music> findAllByMusicNameOrSingersOrAuthors(String musicName, Set<Singer> singers, Set<Author> authors);

}
