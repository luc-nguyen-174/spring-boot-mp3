package com.example.mp3.repo.musicRepo;

import com.example.mp3.model.music.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
}
