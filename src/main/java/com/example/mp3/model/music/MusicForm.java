package com.example.mp3.model.music;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class MusicForm {
    private Long id;
    private String musicName;
    private String description;
    private MultipartFile fileName;
    private MultipartFile imageName;
    private String albums;
    private String authors;
    private LocalDateTime uploadTime;

    public MusicForm() {
    }

    public MusicForm(String musicName, String description, MultipartFile fileName, MultipartFile imageName, String albums, String authors, LocalDateTime uploadTime) {
        this.musicName = musicName;
        this.description = description;
        this.fileName = fileName;
        this.imageName = imageName;
        this.albums = albums;
        this.authors = authors;
        this.uploadTime = uploadTime;
    }

    public MusicForm(Long id, String musicName, String description, MultipartFile fileName, MultipartFile imageName, String albums, String authors, LocalDateTime uploadTime) {
        this.id = id;
        this.musicName = musicName;
        this.description = description;
        this.fileName = fileName;
        this.imageName = imageName;
        this.albums = albums;
        this.authors = authors;
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

    public MultipartFile getFileName() {
        return fileName;
    }

    public void setFileName(MultipartFile fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getImageName() {
        return imageName;
    }

    public void setImageName(MultipartFile imageName) {
        this.imageName = imageName;
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

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
