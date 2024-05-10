package com.example.codifygit2.controller;

import com.example.codifygit2.dto.request.ConcatenationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ConcatenationControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConcatenationOfTwoStrings_OK() throws Exception{
        ConcatenationRequest concat = new ConcatenationRequest();
        concat.setString1("hello");
        concat.setString2("world");

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + this.port + "/api/concatenation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(concat)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("helloworld"));
    }

    @Test
    void testConcatenationOfTwoStrings_isNull() throws Exception{
        ConcatenationRequest concat = new ConcatenationRequest();

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + this.port + "/api/concatenation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(concat)))
                .andExpect(status().isOk())
                .andExpect(content().string("String must not be null"));
    }

}