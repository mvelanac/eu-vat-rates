package com.msg.vatrates.controller;

import com.msg.vatrates.service.VatratesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VatratesController.class)
public class VatratesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VatratesService vatratesService;

    @Test
    public void getHighestStandardVatRatesTest() throws Exception {

        InputStream is = Test.class.getResourceAsStream("/vatrates.json");

        this.mockMvc
                .perform(post("/api/v1/highest-standard-vatrates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(is.readAllBytes()))
                .andExpect(status().isOk());
    }

    @Test
    public void getHighestStandardVatRatesParamTest() throws Exception {

        InputStream is = Test.class.getResourceAsStream("/vatrates.json");

        this.mockMvc
                .perform(post("/api/v1/highest-standard-vatrates?resultNo=3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(is.readAllBytes()))
                .andExpect(status().isOk());
    }

    @Test
    public void getLowestReducedVatRatesTest() throws Exception {

        InputStream is = Test.class.getResourceAsStream("/vatrates.json");

        this.mockMvc
                .perform(post("/api/v1/lowest-reduced-vatrates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(is.readAllBytes()))
                .andExpect(status().isOk());
    }

    @Test
    public void getLowestReducedVatRatesParamTest() throws Exception {

        InputStream is = Test.class.getResourceAsStream("/vatrates.json");

        this.mockMvc
                .perform(post("/api/v1/lowest-reduced-vatrates?resultNo=3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(is.readAllBytes()))
                .andExpect(status().isOk());
    }
}
