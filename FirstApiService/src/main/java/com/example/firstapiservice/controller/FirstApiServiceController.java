package com.example.firstapiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstApiServiceController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First Api Service";
    }
}
