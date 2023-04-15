package com.example.mp3.service.music.interfaceMusic;
import com.example.mp3.model.music.Singer;
import com.example.mp3.service.IGeneralService;

import java.util.Set;

public interface ISingerService extends IGeneralService<Singer> {
    Singer findBySingerName(String name);
    Set<Singer> getBySingerName(Set<String> singerName);
}
