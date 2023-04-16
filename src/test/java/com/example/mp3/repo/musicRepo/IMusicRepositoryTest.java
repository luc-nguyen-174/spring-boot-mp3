//package com.example.mp3.repo.musicRepo;
//
//import com.example.mp3.model.music.Music;
//import com.example.mp3.model.music.Singer;
//import com.example.mp3.service.music.interfaceMusic.IMusicService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static junit.framework.TestCase.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//class IMusicRepositoryTest {
//
//    @Mock
//    private IMusicRepository musicRepository;
//    @InjectMocks
//    private IMusicService service;
//
//    @Test
//    void findAllBySingerName() {
//        Singer singer = new Singer(1L, "noo phuoc thinh", "nam", LocalDate.of(1990, 10, 9), "abc", "abc");
//        Music music = new Music(1L, "bai hat 1", "desc", "bai hat 1", "anh 1", "albums", "luc", LocalDateTime.now());
//
//        List<Music> musics = new ArrayList<>();
//        List<Singer> singers = new ArrayList<>();
//        musics.add(music);
//        singers.add(singer);
//        when(musicRepository.findAllBySingerName("noo")).thenReturn(musics);
//
//        Iterable<Music> rs = service.findAllBySingerName("noo");
//
//
//        assertNotNull(rs);
//        assertTrue(rs.iterator().hasNext());
//        assertEquals(music, rs.iterator().next());
//    }
//}