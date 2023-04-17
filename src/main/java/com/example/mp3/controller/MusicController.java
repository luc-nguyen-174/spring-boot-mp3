package com.example.mp3.controller;

import com.example.mp3.model.music.Kind;
import com.example.mp3.model.music.Music;
import com.example.mp3.model.music.MusicForm;
import com.example.mp3.service.music.interfaceMusic.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/musics")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @Autowired
    Environment environment;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Iterable<Music>> showListMusic() {
        List<Music> musics = (List<Music>) musicService.findAll();
        if (musics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(musics, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Music> createMusic(MultipartHttpServletRequest request) {

        Music music = new Music(request.getParameter("musicName"), request.getParameter("description"),
                request.getParameter("albums"), request.getParameter("authors"));

        MultipartFile fileMultipart = request.getFile("fileName");
        String fileName = fileMultipart.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")); // Lấy phần mở rộng của tệp
        String randomFileName = UUID.randomUUID().toString(); // Tạo tên tệp ngẫu nhiên

        String fileUpload = environment.getProperty("upload.path").toString();

        MultipartFile imageMultipart = request.getFile("imageName");
        String imageName = imageMultipart.getOriginalFilename();
        String imageExtension = imageName.substring(imageName.lastIndexOf(".")); // Lấy phần mở rộng của tệp
        String randomImageName = UUID.randomUUID().toString(); // Tạo tên tệp ngẫu nhiên

        String imageUpload = environment.getProperty("upload.path").toString();

        try {
            fileMultipart.transferTo(new File(fileUpload + randomFileName + fileName + fileExtension));
            imageMultipart.transferTo(new File(imageUpload + randomImageName + imageName + imageExtension));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        music.setFileName(randomFileName + fileName);
        music.setImageName(randomImageName + imageName);
        music.setUploadTime(LocalDateTime.now());
        musicService.save(music);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
