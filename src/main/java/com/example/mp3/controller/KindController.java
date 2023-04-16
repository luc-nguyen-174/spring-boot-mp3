package com.example.mp3.controller;

import com.example.mp3.model.music.Kind;
import com.example.mp3.service.music.interfaceMusic.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/kinds")
public class KindController {
    @Autowired
    IKindService kindService;
    @GetMapping()
    public ResponseEntity<Iterable<Kind>> showListKind(){
        List<Kind> kinds = (List<Kind>) kindService.findAll();
        if(kinds.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(kinds, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Kind> createKind(@RequestBody Kind kind){
        return ResponseEntity.ok(kindService.save(kind));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kind> updateKind(@PathVariable Long id, @RequestBody Kind kind){
        Optional<Kind> optionalKind = kindService.findById(id);
        if(optionalKind.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        kind.setId(optionalKind.get().getId());
        return new ResponseEntity<>(kindService.save(kind), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kind> deleteKind(@PathVariable Long id){
        Optional<Kind> optionalKind =kindService.findById(id);
        if(optionalKind.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        kindService.remove(id);
        return new ResponseEntity<>(optionalKind.get(), HttpStatus.NO_CONTENT);
    }
}
