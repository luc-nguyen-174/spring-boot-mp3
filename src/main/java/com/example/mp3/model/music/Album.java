package com.example.mp3.model.music;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String albumName;
    @ManyToMany(mappedBy = "albums")
    Set<Singer> singers;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "albums_music", joinColumns = {
            @JoinColumn(name = "album_id")},
            inverseJoinColumns = {@JoinColumn(name = "music_id")})
    Set<Music> musics;

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }
}
