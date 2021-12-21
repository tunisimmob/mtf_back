package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Actualites;
import com.ingarch.promoteur.repository.ActualitesRepository;
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
public class ActualitesController {


    @Autowired
    ActualitesRepository actualitesRepository;


    @PostMapping("/actualite")
    public ResponseEntity<?> createActualites(@Valid @RequestBody Actualites actualites) {
            Actualites result = actualitesRepository.save(actualites);
            return ResponseEntity.ok().body(result);
    }


    @PutMapping("/actualite")
    public ResponseEntity<Actualites> updateActualites(@Valid @RequestBody Actualites actualites) {
        Actualites result = actualitesRepository.save(actualites);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/actualite")
    public List<Actualites> getAllActualites() {
        return actualitesRepository.findAll();
    }


    @GetMapping("/actualite/{id}")
    public ResponseEntity<Optional<Actualites>> getActualites(@PathVariable Long id) {
        Optional<Actualites> actualites = actualitesRepository.findById(id);
        return ResponseEntity.ok().body(actualites);
    }


    @DeleteMapping("/actualite/{id}")
    public ResponseEntity<Void> deleteActualites(@PathVariable Long id) {
        actualitesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
