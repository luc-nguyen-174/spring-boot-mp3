package com.example.mp3.model.music;

import com.example.mp3.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playlistName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_kind",
            joinColumns = {@JoinColumn(name = "list_id")},
            inverseJoinColumns = {@JoinColumn(name = "kind_id")})
    @JsonIgnore
    private Set<Kind> kinds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "playlists_musics",
            joinColumns = {@JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "music_id")}
    )
    @JsonIgnore
    private Set<Music> musics;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_users",
            joinColumns = {@JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")})
    @JsonIgnore
    private Set<AppUser> users;

    private String description;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastUpdatedTime;
    private Long viewsNumber;

    public Playlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Set<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(Set<Kind> kinds) {
        this.kinds = kinds;
    }

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Long getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(Long viewsNumber) {
        this.viewsNumber = viewsNumber;
    }
}
