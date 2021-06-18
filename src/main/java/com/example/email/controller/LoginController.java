package com.example.email.controller;

import com.example.email.dto.LoginDto;
import com.example.email.entity.User;
import com.example.email.jwt.JwtProvider;
import com.example.email.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {

            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            User user = (User) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(loginDto.getEmail(),user.getRoles());
            return ResponseEntity.status(201).body(new ApiResponse(token, true));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(403).body(new ApiResponse("Cheklangan", false));
        }
    }
}