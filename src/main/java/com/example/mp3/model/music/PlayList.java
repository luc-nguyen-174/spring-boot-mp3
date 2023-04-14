package com.example.mp3.model.music;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playlistName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_kind", joinColumns = {
            @JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "kind_id")})
    private Set<Kind> kindSet;
    @ManyToMany(mappedBy = "playlists")
    private Set<Music> musicSet;
    private String desc;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
    private Long viewNumber;
    public PlayList() {
    }
    public PlayList(String playlistName, Set<Kind> kindSet, Set<Music> musicSet, String desc, LocalDate dateCreated, LocalDate dateUpdated, Long viewNumber) {
        this.playlistName = playlistName;
        this.kindSet = kindSet;
        this.musicSet = musicSet;
        this.desc = desc;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.viewNumber = viewNumber;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Set<Kind> getKindSet() {
        return kindSet;
    }

    public void setKindSet(Set<Kind> kindSet) {
        this.kindSet = kindSet;
    }

    public Set<Music> getMusicSet() {
        return musicSet;
    }

    public void setMusicSet(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Long getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Long viewNumber) {
        this.viewNumber = viewNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
