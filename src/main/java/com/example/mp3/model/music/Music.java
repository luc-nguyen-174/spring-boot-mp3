package com.example.mp3.model.music;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "musics_singers",
            joinColumns = {@JoinColumn(name = "music_id")},
            inverseJoinColumns = {@JoinColumn(name = "singers_id")}
    )
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Singer> singers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "musics_kinds",
            joinColumns = {@JoinColumn(name = "music_id")},
            inverseJoinColumns = {@JoinColumn(name = "kinds_id")}
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Kind> kinds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "musics_albums",
            joinColumns = {@JoinColumn(name = "music_id")},
            inverseJoinColumns = {@JoinColumn(name = "kinds_id")}
    )
    private Set<Album> albums;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "musics_author",
            joinColumns = {@JoinColumn(name = "music_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors;

    @ManyToMany(mappedBy = "musics")
    private Set<Playlist> playlists;

    private LocalDateTime uploadTime;


    public Music() {
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

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    public Set<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(Set<Kind> kinds) {
        this.kinds = kinds;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
}
