package com.example.mp3.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "singers")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String singerName;
    private String gender;
    private Date birthday;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "singers_kinds",
            joinColumns = {@JoinColumn(name = "singers_id")},
            inverseJoinColumns = {@JoinColumn(name = "kinds_id")}
    )
    @JsonIgnore
    private Set<Kind> kinds;


    private String story;

    @OneToMany(mappedBy = "singers")
    @JsonIgnore
    private Set<Music> musics;
    private String image;

    private String otherInformation;

    public Singer() {
    }

    public Singer(String singerName, String gender, Date birthday, String story, String otherInformation, String fileName) {
        this.singerName = singerName;
        this.gender = gender;
        this.birthday = birthday;
        this.story = story;
        this.otherInformation = otherInformation;
        this.image = fileName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
