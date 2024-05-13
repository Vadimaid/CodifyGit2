package com.example.codifygit2.controller.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    private String BASE_URL;

    @BeforeEach
    void setUp() {
        this.BASE_URL = String.format("http://localhost:%s/", port);
    }


    @Test
    void mult_OK()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(this.BASE_URL + "api/mult")
                        .param("a","5")
                        .param("b","2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
