package com.example.codifygit2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSayHello_OK() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + this.port + "/api/test-1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Hello world"));
    }

    @Test
    void testMult_OK() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + this.port + "/api/mult")
                .param("a","5")
                .param("b","2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("10"));
    }

}