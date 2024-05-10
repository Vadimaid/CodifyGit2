package com.example.codifygit2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/test-1")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping(value = "/test-10")
    public String sayHello10(
            @RequestParam(value = "name", required = false) String name
    ) {
        if (Objects.isNull(name)) {
            return "Hello world";
        }
       return "Hello " + name;
    }

    private void test() {
        System.out.println(this.getClass());
    }

    private void test2() {
        System.out.println("test");
    }
}
