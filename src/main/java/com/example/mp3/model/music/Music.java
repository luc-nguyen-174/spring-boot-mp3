package com.example.mp3.model.music;

import javax.persistence.*;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
