package com.example.mp3.repo.musicRepo;

import com.example.mp3.model.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IMusicRepository extends JpaRepository<Music, Long> {
    Iterable<Music> findAllByAlbumsContainingIgnoreCase(String album);

    @Query(nativeQuery = true,
            value = "select m.id    as music_id," +
                    " m.albums       as albumsName," +
                    " m.authors as authorName," +
                    " m.description  as description," +
                    " m.file_name    as fileName," +
                    " m.image_name   as image," +
                    " m.music_name   as musicName," +
                    " m.upload_time  as uploadTime," +
                    " s.id           as singer_id," +
                    " s.birthday     as birthday," +
                    " s.gender       as gender," +
                    " s.other_information ortherInformation," +
                    " s.singer_name  as singer_name," +
                    " s.story" +
                    " from musics m " +
                    " left join musics_singers ms on m.id = ms.music_id" +
                    " left join singers s on s.id = ms.singers_id " +
                    " where s.singer_name LIKE CONCAT('%', :singer_name, '%')")
    Iterable<Music> findAllBySingerName(@Param("singer_name") String singer_name);

//    Iterable<Music> findAllBy
}
