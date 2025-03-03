package com.team21.backend.controllers;

import com.team21.backend.models.User;
import com.team21.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userService.isUsernameTaken(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
