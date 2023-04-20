package com.example.mp3.repo.musicRepo;

import com.example.mp3.model.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMusicRepository extends JpaRepository<Music, Long> {
    Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album);
    Iterable<Music> findAllByMusicNameContaining(String name);
}
