package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest req) {
        User u = new User();
        u.setName(req.name);
        u.setEmail(req.email);
        u.setPassword(req.password);
        service.register(u);
        return new AuthResponse("User registered");
    }

    @PostMapping("/login")
    public AuthResponse login() {
        return new AuthResponse("Login successful (security disabled)");
    }
}
