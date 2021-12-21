package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Projet;
import com.ingarch.promoteur.payload.response.MessageResponse;
import com.ingarch.promoteur.repository.ProjetRepository;
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
public class ProjetController {


    @Autowired
    ProjetRepository projetRepository;


    @PostMapping("/projet")
    public ResponseEntity<?> createProjet(@Valid @RequestBody Projet projet) {
            Projet result = projetRepository.save(projet);
            return ResponseEntity.ok().body(result);

    }

    @GetMapping("/countsencours")
    public Integer getnumberencours() {
        return projetRepository.countByEtat("en_cours");
    }


    @PutMapping("/projet")
    public ResponseEntity<Projet> updateProjet(@Valid @RequestBody Projet projet) {
        Projet result = projetRepository.save(projet);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/projet")
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }


    @GetMapping("/projetencours")
    public Projet getProjetencours() {
        return projetRepository.findProjetByEtat("en_cours");
    }

    @GetMapping("/projetenfinis")
    public List<Projet> getProjetenfinis() {
        return projetRepository.findProjetByEtatOrderById("fini");
    }


    @GetMapping("/projet/{id}")
    public ResponseEntity<Optional<Projet>> getProjet(@PathVariable Long id) {
        Optional<Projet> projet = projetRepository.findById(id);
        return ResponseEntity.ok().body(projet);
    }


    @DeleteMapping("/projet/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/countproject")
    public Long countprojet() {
        return projetRepository.count();
    }
}
