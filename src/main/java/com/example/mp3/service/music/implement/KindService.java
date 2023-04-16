package com.example.mp3.service.music.implement;

import com.example.mp3.model.music.Kind;
import com.example.mp3.repo.musicRepo.IKindRepo;
import com.example.mp3.service.music.interfaceMusic.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KindService implements IKindService {
    @Autowired
    private IKindRepo kindRepo;

    @Override
    public Iterable<Kind> findAll() {
        return kindRepo.findAll();
    }

    @Override
    public Optional<Kind> findById(Long id) {
        return kindRepo.findById(id);
    }

    @Override
    public Kind save(Kind kind) {
        return kindRepo.save(kind);
    }

    @Override
    public void remove(Long id) {
        kindRepo.deleteById(id);
    }
}
