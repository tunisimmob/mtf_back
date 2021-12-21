package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Video;
import com.ingarch.promoteur.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Transactional
public class VideoController {


    @Autowired
    VideoRepository videoRepository;


    @PostMapping("/video")
    public ResponseEntity<Video> createVideo(@Valid @RequestBody Video video) {
        Video result = videoRepository.save(video);
        return ResponseEntity.ok().body(result);
    }


    @PutMapping("/video")
    public ResponseEntity<Video> updateVideo(@Valid @RequestBody Video video) {
        Video result = videoRepository.save(video);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/video")
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }


    @GetMapping("/video/{id}")
    public ResponseEntity<Optional<Video>> getVideo(@PathVariable Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return ResponseEntity.ok().body(video);
    }


    @DeleteMapping("/video/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/countvideo")
    public Long countVideo() {
        return videoRepository.count();
    }
}
