package com.example.mp3.controller;

import com.example.mp3.model.music.Music;
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

    // GET all playlists
    @GetMapping
    public ResponseEntity<List<Playlist>> getALlPlaylist() {
        List<Playlist> playlists = (List<Playlist>) playlistService.findAll();
        if (playlists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        }
    }

    // GET playlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        return playlistOptional.map(playlist
                -> new ResponseEntity<>(playlist, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST create playlist
    @PostMapping("/create")
    public ResponseEntity<Playlist> save(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }

    // PUT update playlist
    @PutMapping("/update/{id}")
    public ResponseEntity<Playlist> update(@PathVariable Long id, @RequestBody Playlist playlist) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlist.setId(id);
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.OK);
    }

    // DELETE playlist by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Playlist> delete(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistService.remove(id);
        return new ResponseEntity<>(playlistOptional.get(), HttpStatus.OK);
    }

    // POST add music to playlist
    @PostMapping("/{playlistId}/musics/{musicId}")
    public void addSongToPlaylist(@PathVariable("playlistId") Long playlistId, @PathVariable("musicId") Long musicId) {
        playlistService.addMusicToPlaylist(playlistId, musicId);
    }

    // DELETE remove music from playlist
    @DeleteMapping("/{playlistId}/musics/{musicId}")
    public void removeSongFromPlaylist(@PathVariable("playlistId") Long playlistId, @PathVariable("musicId") Long musicId) {
        playlistService.removeMusicFromPlaylist(playlistId, musicId);
    }

}
