package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Appartement;
import com.ingarch.promoteur.models.Projet;
import com.ingarch.promoteur.repository.AppartementRepository;
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
public class AppartementController {


    @Autowired
    AppartementRepository appartementRepository;


    @PostMapping("/appartement")
    public ResponseEntity<Appartement> createAppartement(@Valid @RequestBody Appartement appartement) {
        Appartement result = appartementRepository.save(appartement);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/appartement/{id}")
    public ResponseEntity<Optional<Appartement>> getAppartement(@PathVariable Long id) {
        Optional<Appartement> projet = appartementRepository.findById(id);
        return ResponseEntity.ok().body(projet);
    }

    @PutMapping("/appartement")
    public ResponseEntity<Appartement> updateAppartement(@Valid @RequestBody Appartement appartement) {
        Appartement result = appartementRepository.save(appartement);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/appartement")
    public List<Appartement> getAllAppartement() {
        return appartementRepository.findAll();
    }


    @GetMapping("/projets/encours/appartements/s0_type")
    public Appartement getAppartementS0() {
        return appartementRepository.findTop1AppartementByNombrechambreAndProjetEtat("0","en_cours");
    }

    @GetMapping("/projets/encours/appartements/s1_type")
    public Appartement getAppartementS1() {
        return appartementRepository.findTop1AppartementByNombrechambreAndProjetEtat("1","en_cours");
    }

    @GetMapping("/projets/encours/appartements/s2_type")
    public Appartement getAppartementS2() {
        return appartementRepository.findTop1AppartementByNombrechambreAndProjetEtat("2","en_cours");
    }

    @GetMapping("/projets/encours/appartements/s3_type")
    public Appartement getAppartementS3() {
        return appartementRepository.findTop1AppartementByNombrechambreAndProjetEtat("3","en_cours");
    }


    @GetMapping("/projets/encours/appartements/commerce_type")
    public Appartement getAppartementCommerce() {
        return appartementRepository.findTop1AppartementByNombrechambreAndProjetEtat("4","en_cours");
    }



    @GetMapping("/projets/fini/appartements/s0_type")
    public List<Appartement> getAppartementsS0() {
        return appartementRepository.findByNombrechambreAndProjetEtat("0","fini");
    }

    @GetMapping("/projets/fini/appartements/s1_type")
    public List<Appartement> getAppartementsS1() {
        return appartementRepository.findByNombrechambreAndProjetEtat("1","fini");
    }

    @GetMapping("/projets/fini/appartements/s2_type")
    public List<Appartement> getAppartementsS2() {
        return appartementRepository.findByNombrechambreAndProjetEtat("2","fini");
    }

    @GetMapping("/projets/fini/appartements/s3_type")
    public List<Appartement> getAppartementsS3() {
        return appartementRepository.findByNombrechambreAndProjetEtat("3","fini");
    }


    @GetMapping("/projets/fini/appartements/commerce_type")
    public List<Appartement> getAppartementsCommerce() {
        return appartementRepository.findByNombrechambreAndProjetEtat("4","fini");
    }


    @DeleteMapping("/appartement/{id}")
    public ResponseEntity<Void> deleteAppartement(@PathVariable Long id) {
        appartementRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/countappartement")
    public Long countappartement() {
        return appartementRepository.count();
    }
}
