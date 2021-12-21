package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Contact;
import com.ingarch.promoteur.models.Presentation;
import com.ingarch.promoteur.payload.response.MessageResponse;
import com.ingarch.promoteur.repository.PresentationRepository;
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
public class PresentationController {


    @Autowired
    PresentationRepository presentationRepository;


    @PostMapping("/presentation")
    public ResponseEntity<?> createPresentation(@Valid @RequestBody Presentation presentation) {
        if (presentationRepository.count() >= 1) {
            return ResponseEntity.badRequest().body(new MessageResponse("you can't create more than one row"));

        } else {
            Presentation result = presentationRepository.save(presentation);
            return ResponseEntity.ok().body(result);
        }
    }


    @PutMapping("/presentation")
    public ResponseEntity<Presentation> updatePresentation(@Valid @RequestBody Presentation presentation) {
        Presentation result = presentationRepository.save(presentation);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/presentation")
    public List<Presentation> getAllPresentation() {
        return presentationRepository.findAll();
    }


    @GetMapping("/lastpresentation")
    public ResponseEntity<Presentation> getLastpresentation() {
        Presentation result = presentationRepository.findTop1ByOrderByIdDesc();
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/presentation/{id}")
    public ResponseEntity<Optional<Presentation>> getPresentation(@PathVariable Long id) {
        Optional<Presentation> presentation = presentationRepository.findById(id);
        return ResponseEntity.ok().body(presentation);
    }


    @DeleteMapping("/presentation/{id}")
    public ResponseEntity<Void> deletePresentation(@PathVariable Long id) {
        presentationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
