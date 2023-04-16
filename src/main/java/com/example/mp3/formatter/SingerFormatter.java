package com.example.mp3.formatter;

import com.example.mp3.model.music.Singer;
import com.example.mp3.service.music.interfaceMusic.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class SingerFormatter implements Formatter<Singer> {
    private ISingerService singerService;
    @Autowired
    public SingerFormatter(ISingerService singerService) {
        this.singerService = singerService;
    }

    @Override
    public Singer parse(String text, Locale locale) throws ParseException {
        Optional<Singer> singerOptional = singerService.findById(Long.parseLong(text));
        return singerOptional.orElse(null);
    }

    @Override
    public String print(Singer object, Locale locale) {
        return "[" + object.getId() + ", " +object.getSingerName() + "]";
    }
}
