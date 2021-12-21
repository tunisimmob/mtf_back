package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Contact;
import com.ingarch.promoteur.payload.response.MessageResponse;
import com.ingarch.promoteur.repository.ContactRepository;
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
public class ContactController {


    @Autowired
    ContactRepository contactRepository;


    @PostMapping("/contact")
    public ResponseEntity<?> createContact(@Valid @RequestBody Contact contact) {
        if (contactRepository.count() >= 1) {
            return ResponseEntity.badRequest().body(new MessageResponse("you can't create more than one row"));

        } else {
            Contact result = contactRepository.save(contact);
            return ResponseEntity.ok().body(result);
        }
    }


    @PutMapping("/contact")
    public ResponseEntity<Contact> updateContact(@Valid @RequestBody Contact contact) {
        Contact result = contactRepository.save(contact);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/contact")
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }


    @GetMapping("/contact/{id}")
    public ResponseEntity<Optional<Contact>> getContact(@PathVariable Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return ResponseEntity.ok().body(contact);
    }

    @GetMapping("/lastcontact")
    public ResponseEntity<Contact> getLastcontact() {
        Contact result = contactRepository.findTop1ByOrderByIdDesc();
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
