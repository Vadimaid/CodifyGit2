package com.example.codifygit2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/test-1")
    public String sayHello() {
        return "Hello world";
    }

    @PostMapping(value = "/mult")
    public String mult(@RequestParam int a, @RequestParam int b) {
        return String.valueOf(a * b);
    }

}
