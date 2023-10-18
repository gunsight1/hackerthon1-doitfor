package com.kernel360.doitforme.controller;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UrlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @RepeatedTest(5)
    public void testShortUrl() throws Exception {
        String originalUrl = "http://example.com/original-url";

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/shoutUrl")
                            .param("originalUrl", originalUrl))
                    .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                    .andExpect(MockMvcResultMatchers.redirectedUrl("/result?convertUrl=YOUR_EXPECTED_CONVERTED_URL"));
        }

}