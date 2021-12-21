package com.ingarch.promoteur.controllers;


import com.ingarch.promoteur.models.User;
import com.ingarch.promoteur.repository.UserRepository;
import com.ingarch.promoteur.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")


public class UserController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @GetMapping("/users")
    public List<User> getAllUtilisateur() {
        List<User> Utilisateur = new ArrayList<>();
        userRepository.findAll().forEach(Utilisateur::add);

        return Utilisateur;
    }


//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUtilisateur(@PathVariable("id") long id, @RequestBody User Utilisateur) {
//        System.out.println("Update Utilisateur with ID = " + id + "...");
//
//        Optional<User> UtilisateurInfo = userRepository.findById(id);
//
//        if (UtilisateurInfo.isPresent()) {
//            User utilisateur = UtilisateurInfo.get();
//            utilisateur.setEmail(Utilisateur.getEmail());
//            utilisateur.setUsername(Utilisateur.getUsername());
//            utilisateur.setPassword(Utilisateur.getPassword());
//            utilisateur.setNom(utilisateur.getNom());
//            utilisateur.setAct(utilisateur.getAct());
//            utilisateur.setTel(utilisateur.getTel());
//            utilisateur.setGsm(utilisateur.getGsm());
//            utilisateur.setFax(utilisateur.getFax());
//            utilisateur.setAdresse(utilisateur.getAdresse());
//            utilisateur.setVille(utilisateur.getVille());
//            utilisateur.setGouvernorat(utilisateur.getGouvernorat());
//            utilisateur.setOrdre(utilisateur.getOrdre());
//            utilisateur.setWeb(utilisateur.getWeb());
//            utilisateur.setLogo(utilisateur.getLogo());
//            utilisateur.setStatut(utilisateur.getStatut());
//            return new ResponseEntity<>(userRepository.save(Utilisateur), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).get();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/userbyRoleid/{id}")
    public List<User> getUserByRoleid(@PathVariable Integer id) {
        return userRepository.findUserByRolesId(id);
    }


    @PutMapping("/users/{id}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(users -> {
                    user.setEmail(user.getEmail());
                    user.setUsername(user.getUsername());
                    user.setPassword(user.getPassword());
                    user.setNom(user.getNom());
                    user.setTel(user.getTel());
                    user.setFax(user.getFax());
                    user.setAdresse(user.getAdresse());
                    user.setVille(user.getVille());
                    user.setLogo(user.getLogo());
                    user.setPrenom(user.getPrenom());

                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    return userRepository.save(user);
                });
    }


    @PutMapping("/updateusers")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }


}
