package com.example.codifygit2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/test-1")
    public String sayHello() {
        return "Hello world";
    }
    @GetMapping(value = "/test-2")
    public Integer difference(
            @RequestParam Integer a,
            @RequestParam Integer b
    ){
        int c =a-b;
        return c;
    }
}
