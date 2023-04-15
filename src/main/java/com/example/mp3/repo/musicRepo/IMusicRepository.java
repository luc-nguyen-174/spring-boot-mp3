package com.example.mp3.repo.musicRepo;

import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IMusicRepository extends JpaRepository<Music, Long> {
    Iterable<Music> findAllByMusicNameContainingIgnoreCaseOrSingersContainingIgnoreCaseOrAuthorsNotContainingIgnoreCase(
            String musicName, Singer singers, String authors);

    Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album);

}
