package com.example.codifygit2.controller;

import com.example.codifygit2.dto.request.ConcatenationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ConcatenationController {
    @PostMapping(value = "/concatenation")
    public String concatenationOfTwoStrings(@RequestBody ConcatenationRequest concat){
        try {
            if (Objects.isNull(concat.getString1()) || Objects.isNull(concat.getString2())){
                throw new IllegalArgumentException("String must not be null");
            }
            return concat.getString1()+concat.getString2();
        }
        catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
