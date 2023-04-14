package com.example.mp3.repo.musicRepo;

import com.example.mp3.model.music.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISingerRepo extends JpaRepository<Singer, Long> {
    Singer findBySingerName(String name);

}
