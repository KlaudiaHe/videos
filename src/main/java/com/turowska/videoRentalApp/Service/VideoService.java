package com.turowska.videoRentalApp.Service;

import com.turowska.videoRentalApp.Dao.Entity.Video;
import com.turowska.videoRentalApp.Dao.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VideoService {

    private VideoRepo videoRepo;

    @Autowired
    public VideoService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public Optional<Video> findById(Long id){
        return videoRepo.findById(id);
    }

    public Iterable<Video> findAll(){
        return videoRepo.findAll();
    }

    public Video save(Video video){
        return videoRepo.save(video);
    }

    public void deleteById(Long id){
        videoRepo.deleteById(id);
    }

        @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Video(1L, "Snatch", LocalDate.of(2000, 1,1)));
        save(new Video(2L, "Pulp Fiction", LocalDate.of(1998, 10,15)));
        save(new Video(3L, "Call me by your name", LocalDate.of(2017, 1,22)));
        save(new Video(4L, "Howl's Moving Castle", LocalDate.of(2004, 9,5)));
        save(new Video(5L, "Dune", LocalDate.of(1984, 12,3)));
        }

    }