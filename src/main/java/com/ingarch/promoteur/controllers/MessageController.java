package com.ingarch.promoteur.controllers;

import com.ingarch.promoteur.models.Message;
import com.ingarch.promoteur.repository.MessageRepository;
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
public class MessageController {


    @Autowired
    MessageRepository messageRepository;


    @PostMapping("/message")
    public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message) {
        Message result = messageRepository.save(message);
        return ResponseEntity.ok().body(result);
    }


    @PutMapping("/message")
    public ResponseEntity<Message> updateMessage(@Valid @RequestBody Message message) {
        Message result = messageRepository.save(message);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/message")
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }


    @GetMapping("/message/{id}")
    public ResponseEntity<Optional<Message>> getMessage(@PathVariable Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return ResponseEntity.ok().body(message);
    }


    @DeleteMapping("/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/countmessage")
    public Long countMessage() {
        return messageRepository.count();
    }

}
