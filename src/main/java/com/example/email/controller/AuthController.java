package com.example.email.controller;

import com.example.email.dto.RegisterDto;
import com.example.email.response.ApiResponse;
import com.example.email.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        ApiResponse registr = authService.registr(registerDto);
        return ResponseEntity.ok(registr.isStatus()?201:409);
    }
    @GetMapping("/verifyemail")
    public ResponseEntity<?> verifyEmail(@RequestParam String emailCode,@RequestParam String sendingEmail){
        ApiResponse apiResponse = authService.verifyEmail(sendingEmail, emailCode);
        return ResponseEntity.status(apiResponse.isStatus()?201:409).body(apiResponse);
    }
}
