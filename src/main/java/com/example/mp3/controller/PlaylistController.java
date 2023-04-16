package com.example.mp3.controller;

import com.example.mp3.model.music.Playlist;
import com.example.mp3.service.music.interfaceMusic.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private IPlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<Playlist>> getALlPlaylist() {
        List<Playlist> playlists = (List<Playlist>) playlistService.findAll();
        if (playlists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> save(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Playlist playlist) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlist.setId(id);
        playlistService.save(playlist);
        return new ResponseEntity<>(playlistOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
