package com.example.mp3.service.music.interfaceMusic;

import com.example.mp3.model.music.Kind;
import com.example.mp3.service.IGeneralService;

import java.util.Set;

public interface IKindService extends IGeneralService<Kind> {
    Set<Kind> getKindByName(Set<String> kindNames);

}
