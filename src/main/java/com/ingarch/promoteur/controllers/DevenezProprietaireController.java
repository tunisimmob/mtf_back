package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.DevenezProprietaire;
import com.ingarch.promoteur.models.Presentation;
import com.ingarch.promoteur.payload.response.MessageResponse;
import com.ingarch.promoteur.repository.DevenezProprietaireRepository;
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
public class DevenezProprietaireController {


    @Autowired
    DevenezProprietaireRepository devenezProprietaireRepository;


    @PostMapping("/devenezProprietaire")
    public ResponseEntity<?> createDevenezProprietaire(@Valid @RequestBody DevenezProprietaire devenezProprietaire) {
        if (devenezProprietaireRepository.count() >= 1) {
            return ResponseEntity.badRequest().body(new MessageResponse("you can't create more than one row"));

        } else {
            DevenezProprietaire result = devenezProprietaireRepository.save(devenezProprietaire);
            return ResponseEntity.ok().body(result);
        }
    }


    @PutMapping("/devenezProprietaire")
    public ResponseEntity<DevenezProprietaire> updateDevenezProprietaire(@Valid @RequestBody DevenezProprietaire devenezProprietaire) {
        DevenezProprietaire result = devenezProprietaireRepository.save(devenezProprietaire);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/devenezProprietaire")
    public List<DevenezProprietaire> getAllDevenezProprietaire() {
        return devenezProprietaireRepository.findAll();
    }

    @GetMapping("/lastdevenezProprietaire")
    public ResponseEntity<DevenezProprietaire> getLastdevenezProprietaire() {
        DevenezProprietaire result = devenezProprietaireRepository.findTop1ByOrderByIdDesc();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/devenezProprietaire/{id}")
    public ResponseEntity<Optional<DevenezProprietaire>> getDevenezProprietaire(@PathVariable Long id) {
        Optional<DevenezProprietaire> devenezProprietaire = devenezProprietaireRepository.findById(id);
        return ResponseEntity.ok().body(devenezProprietaire);
    }


    @DeleteMapping("/devenezProprietaire/{id}")
    public ResponseEntity<Void> deleteDevenezProprietaire(@PathVariable Long id) {
        devenezProprietaireRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
