package com.example.firstapiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstApiServiceController {
    @GetMapping("/welcome")
    public String webcome() {
        return "Welcom to the First Api Service";
    }
}
