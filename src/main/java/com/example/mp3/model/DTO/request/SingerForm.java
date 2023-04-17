package com.example.mp3.model.DTO.request;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.Set;

public class SingerForm {
    private Long id;
    private String singerName;
    private String gender;
    private LocalDate birthday;
    private Set<String> kinds;
    private String story;
    private Set<String> musics;
    private MultipartFile image;
    private String otherInformation;

    public SingerForm() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<String> getKinds() {
        return kinds;
    }

    public void setKinds(Set<String> kinds) {
        this.kinds = kinds;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<String> getMusics() {
        return musics;
    }

    public void setMusics(Set<String> musics) {
        this.musics = musics;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public SingerForm(String singerName, String gender, LocalDate birthday, Set<String> kinds, String story,
                      Set<String> musics, MultipartFile image, String otherInformation) {
        this.singerName = singerName;
        this.gender = gender;
        this.birthday = birthday;
        this.kinds = kinds;
        this.story = story;
        this.musics = musics;
        this.image = image;
        this.otherInformation = otherInformation;

    }
}
