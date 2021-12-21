package com.ingarch.promoteur.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.ingarch.promoteur.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingarch.promoteur.models.ERole;
import com.ingarch.promoteur.models.Role;
import com.ingarch.promoteur.models.User;
import com.ingarch.promoteur.payload.request.LoginRequest;
import com.ingarch.promoteur.payload.request.SignupRequest;
import com.ingarch.promoteur.payload.response.JwtResponse;
import com.ingarch.promoteur.payload.response.MessageResponse;
import com.ingarch.promoteur.repository.RoleRepository;
import com.ingarch.promoteur.repository.UserRepository;
import com.ingarch.promoteur.security.jwt.JwtUtils;
import com.ingarch.promoteur.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        if (!userRepository.existsByEmail(loginRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email is wrong"));
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getPassword(),
                userDetails.getId(),
                userDetails.getUsername(), userDetails.getEmail(), userDetails.getAdresse(),
                userDetails.getAct(), userDetails.getFax(),
                userDetails.getGouvernorat(), userDetails.getAct(),
                userDetails.getGsm(), userDetails.getVille(),
                userDetails.getLogo(), userDetails.getWeb(),
                userDetails.getStatut(), userDetails.getOrdre(), userDetails.getAct(),
                userDetails.getNom(), userDetails.getInstagram(), userDetails.getTwitter(),
                userDetails.getSkype(), userDetails.getFacebook(),
                userDetails.getPrenom(), userDetails.getAboutme(), roles
        ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email is already taken!"));
        }

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_MOD)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {

                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MOD)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;


                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;


                    default:
                        Role testRole = roleRepository.findByName(ERole.ROLE_MOD)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(testRole);

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("Registration Successful");
    }


    @PostMapping("/changepassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody LoginRequest loginRequest) {
        if(userDetailsService.changePassword(loginRequest.getEmail(), loginRequest.getPassword())) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Unable to change password. Try again!"));
        }
    }
}


