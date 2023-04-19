package com.example.mp3.controller;

import com.example.mp3.model.music.*;
import com.example.mp3.service.music.interfaceMusic.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
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
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/musics")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @Autowired
    Environment environment;

    @GetMapping()
    public ResponseEntity<Iterable<Music>> showListMusic() {
        List<Music> musics = (List<Music>) musicService.findAll();
        if (musics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(musics, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Music> createMusic(MultipartHttpServletRequest request) {
        Singer singer = new Singer();
        Music music = new Music(request.getParameter("musicName"), request.getParameter("description"), (Singer) request.getAttribute("singers"), (Set<Kind>) request.getAttribute("kinds"),
                request.getParameter("albums"), request.getParameter("authors"), (List<Playlist>) request.getAttribute("playlits"));

        MultipartFile fileMultipart = request.getFile("fileName");
        String fileName = fileMultipart.getOriginalFilename();

        String fileUpload = environment.getProperty("upload.path").toString();

        MultipartFile imageMultipart = request.getFile("imageName");
        String imageName = imageMultipart.getOriginalFilename();

        String imageUpload = environment.getProperty("upload.path").toString();

        try {
            fileMultipart.transferTo(new File(fileUpload + fileName));
            imageMultipart.transferTo(new File(imageUpload + imageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        music.setFileName(fileName);
        music.setImageName(imageName);
        music.setUploadTime(LocalDateTime.now());
        musicService.save(music);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
