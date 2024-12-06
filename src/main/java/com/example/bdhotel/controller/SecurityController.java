package com.example.bdhotel.controller;

import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.dto.SignupRequest;
import com.example.bdhotel.dto.SigninRequest;
import com.example.bdhotel.models.Client;
import com.example.bdhotel.security.JwtCore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth")
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final DataAccessLayer dataAccessLayer;
    private final PasswordEncoder passwordEncoder;
    private final JwtCore jwtCore;

    @Autowired
    public SecurityController(AuthenticationManager authenticationManager,
                              DataAccessLayer dataAccessLayer,
                              PasswordEncoder passwordEncoder,
                              JwtCore jwtCore) {
        this.authenticationManager = authenticationManager;
        this.dataAccessLayer = dataAccessLayer;
        this.passwordEncoder = passwordEncoder;
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        // Проверка существования клиента по email
        if (dataAccessLayer.existsClientByEmail(signupRequest.getEmail())) {
            log.warn("Attempt to sign up with existing email: {}", signupRequest.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        // Создание нового клиента
        Client client = new Client();
        client.setName(signupRequest.getFullName());
        client.setDateOfBirth(signupRequest.getBirthDate()); // Используйте birthDate вместо age
        client.setPhoneNumber(signupRequest.getPhoneNumber());
        client.setEmail(signupRequest.getEmail());
        client.setPassport(String.valueOf(signupRequest.getPassport())); // Преобразуйте int в String
        client.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        // Сохранение клиента в базе данных
        dataAccessLayer.createClient(client);
        log.info("Successfully signed up client: {}", client.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.warn("Invalid login attempt for email: {}", signinRequest.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);

        log.info("User signed in successfully: {}", signinRequest.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }
}