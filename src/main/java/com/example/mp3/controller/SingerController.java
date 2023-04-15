package com.example.mp3.controller;

import com.example.mp3.model.music.Singer;
import com.example.mp3.service.music.interfaceMusic.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/singers")
public class SingerController {
    @Autowired
    private ISingerService singerService;

    @GetMapping()
    public ResponseEntity<Iterable<Singer>> showListSinger(){
        return ResponseEntity.ok(singerService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Singer> createSinger(@RequestBody Singer singer){
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
