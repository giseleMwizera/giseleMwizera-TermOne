package com.devOpsExam.backend.calculator.integration;

import com.devOpsExam.backend.calculator.CalculatorController;
import com.devOpsExam.backend.calculator.DoMathRequest;
import com.devOpsExam.backend.calculator.MathOperator;
import com.devOpsExam.backend.calculator.MathOperatorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MathOperatorImpl mathOperator;

    @Test
    void itShouldCallMathOperatorImpl() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(4, 10, "+");
        mockMvc.perform(post("/do-math").content(asJsonString(mathRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()
                );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}