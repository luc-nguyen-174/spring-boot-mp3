package com.example.mp3.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String musicName;
    private String description;
    private String fileName;
    private String imageName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "singer_id")
    @JsonIgnore
    private Singer singers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "musics_kinds",
            joinColumns = {@JoinColumn(name = "music_id")},
            inverseJoinColumns = {@JoinColumn(name = "kinds_id")}
    )
    @JsonIgnore
    private Set<Kind> kinds;

    private String albums;

    private String authors;

    @ManyToMany(mappedBy = "musics")
    @JsonIgnore
    private List<Playlist> playlists;

    private LocalDateTime uploadTime;


    public Music() {
    }

    public Music(String musicName, String description, String albums, String authors) {
        this.musicName = musicName;
        this.description = description;
        this.albums = albums;
        this.authors = authors;
    }

    public Music(String musicName, String description, Singer singers, Set<Kind> kinds, String albums, String authors, List<Playlist> playlists) {
        this.musicName = musicName;
        this.description = description;
        this.singers = singers;
        this.kinds = kinds;
        this.albums = albums;
        this.authors = authors;
        this.playlists = playlists;
    }

    public Music(String musicName, String description, String albums, String authors, LocalDateTime uploadTime) {
        this.musicName = musicName;
        this.description = description;
        this.albums = albums;
        this.authors = authors;
        this.uploadTime = uploadTime;
    }

    public Music(String musicName, String description, String fileName, String imageName, String albums, String authors, LocalDateTime uploadTime) {
        this.musicName = musicName;
        this.description = description;
        this.fileName = fileName;
        this.imageName = imageName;
        this.albums = albums;
        this.authors = authors;
        this.uploadTime = uploadTime;
    }

    public Music(Long id, String musicName, String description, String fileName, String imageName, String albums, String authors, LocalDateTime uploadTime) {
        this.id = id;
        this.musicName = musicName;
        this.description = description;
        this.fileName = fileName;
        this.imageName = imageName;
        this.albums = albums;
        this.authors = authors;
        this.uploadTime = uploadTime;
    }

    public Music(Long id, String musicName, String description, String fileName, String imageName, Singer singers, Set<Kind> kinds, String albums, String authors, List<Playlist> playlists, LocalDateTime uploadTime) {
        this.id = id;
        this.musicName = musicName;
        this.description = description;
        this.fileName = fileName;
        this.imageName = imageName;
        this.singers = singers;
        this.kinds = kinds;
        this.albums = albums;
        this.authors = authors;
        this.playlists = playlists;
        this.uploadTime = uploadTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Singer getSingers() {
        return singers;
    }

    public void setSingers(Singer singers) {
        this.singers = singers;
    }

    public Set<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(Set<Kind> kinds) {
        this.kinds = kinds;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
