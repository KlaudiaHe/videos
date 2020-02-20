package com.turowska.videoRentalApp.Api;

import com.turowska.videoRentalApp.Dao.Entity.Video;
import com.turowska.videoRentalApp.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

//    list and constructor were replaced by database:
//    private List<Video> videos;
//    public VideoApi() {
//        videos = new ArrayList<>();
//        videos.add(new Video(1L, "Snatch", LocalDate.of(2000, 1,1)));
//        videos.add(new Video(2L, "Pulp Fiction", LocalDate.of(1998, 10,15)));
//    }

    private VideoService videoService;

    @Autowired
    public VideoApi(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/all")
    public Iterable<Video> getAll() {
        return videoService.findAll();
    }

    @GetMapping
    public Optional<Video> getById(@RequestParam Long index) {
        return videoService.findById(index);
    }

    @PostMapping
    public Video addVideo (@RequestBody Video video){
        return videoService.save(video);
    }

    @PutMapping
    public Video updateVideo (@RequestBody Video video){
        return videoService.save(video);
    }

    @DeleteMapping
    public void deleteVideo (@RequestParam Long index){
        videoService.deleteById(index);
    }
}
