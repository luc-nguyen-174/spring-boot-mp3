package com.example.mp3.model.music;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "singers")
public class Singer {

    @Id
    private Long id;

    private String singerName;
    private String gender;
    private LocalDate birthday;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "singers_kinds",
            joinColumns = {@JoinColumn(name = "singers_id")},
            inverseJoinColumns = {@JoinColumn(name = "kinds_id")}
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Kind> kinds;

    private String story;

    @ManyToMany(mappedBy = "singers")
    private Set<Music> musics;

    private String otherInformation;

    public Singer() {
    }

    public Singer(String singerName, String gender, LocalDate birthday, Set<Kind> kinds, String story, Set<Music> musics, String otherInformation) {
        this.singerName = singerName;
        this.gender = gender;
        this.birthday = birthday;
        this.kinds = kinds;
        this.story = story;
        this.musics = musics;
        this.otherInformation = otherInformation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(Set<Kind> kinds) {
        this.kinds = kinds;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}