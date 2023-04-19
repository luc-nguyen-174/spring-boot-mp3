package com.example.mp3.controller;

import com.example.mp3.model.DTO.request.SingerForm;
import com.example.mp3.model.music.Singer;
import com.example.mp3.service.music.interfaceMusic.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/admin/singers")
public class SingerController {
    @Autowired
    private ISingerService singerService;

    @Autowired
    Environment env;

    @GetMapping()
    public ResponseEntity<Iterable<Singer>> showListSinger(){
        return ResponseEntity.ok(singerService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Singer> createSinger(@ModelAttribute SingerForm singerForm){
        MultipartFile multipartFile = singerForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
//        String randomFileName = UUID.randomUUID().toString(); // Tạo tên tệp ngẫu nhiên
        String fileUpload = env.getProperty("upload.path").toString();

        try {
            FileCopyUtils.copy(singerForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer(singerForm.getSingerName(), singerForm.getGender(), singerForm.getBirthday(),
                singerForm.getStory(), singerForm.getOtherInformation(),fileName);

        return ResponseEntity.ok(singerService.save(singer));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Singer> deleteSinger(@PathVariable Long id){
        Optional<Singer> optionalSinger =singerService.findById(id);
        if(optionalSinger.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singerService.remove(id);
        return new ResponseEntity<>(optionalSinger.get(), HttpStatus.NO_CONTENT);
    }
}