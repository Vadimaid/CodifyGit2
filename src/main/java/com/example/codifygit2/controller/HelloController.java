package com.example.codifygit2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @GetMapping(value = "/hello-for-me")
    public String helloForMe(
            @RequestParam(value = "name", required = false) String name
    ) {
        return "Hello " + name + "!";
    }
}
