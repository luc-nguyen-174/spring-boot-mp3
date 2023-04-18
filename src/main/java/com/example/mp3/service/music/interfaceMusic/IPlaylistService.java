package com.example.mp3.service.music.interfaceMusic;

import com.example.mp3.model.DTO.response.ResponseMessage;
import com.example.mp3.model.music.Playlist;
import com.example.mp3.service.IGeneralService;

public interface IPlaylistService extends IGeneralService<Playlist> {
    Playlist addMusicToPlaylist(Long playlistId, Long musicId);
    void removeMusicFromPlaylist(Long playlistId, Long musicId);
}
