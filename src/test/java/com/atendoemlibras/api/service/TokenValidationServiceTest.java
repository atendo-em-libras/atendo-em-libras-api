package com.atendoemlibras.api.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenValidationServiceTest {

    @InjectMocks
    private TokenValidationService tokenValidationService;

    private String token;

    @BeforeEach
    void configure() {
        MockitoAnnotations.openMocks(this);

        token = "testtoken";

        try {
            ReflectionTestUtils.setField(tokenValidationService, "profileToken", token, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tokenValidationService = new TokenValidationService();
    }

    @Test
    void shouldExecuteFunctionWithValidToken() {
        Supplier<Boolean> execution = () -> { return true; };

       assertTrue(tokenValidationService.executeIfHasValidToken(token, execution));
    }

}