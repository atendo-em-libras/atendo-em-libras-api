package com.atendoemlibras.api.service;

import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.exceptions.TokenIsNotValidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenValidationServiceTest {

    @InjectMocks
    private TokenValidationService tokenValidationService;

    private String token;

    @BeforeEach
    void configure() throws Exception {
        MockitoAnnotations.openMocks(this);
        token = "testtoken";
        tokenValidationService = new TokenValidationService(token);
    }

    @Test
    void shouldExecuteFunctionWithValidToken() {
        Supplier<Boolean> execution = () -> { return true; };
        assertTrue(tokenValidationService.executeIfHasValidToken(token, execution));
    }

    @Test
    void shouldExecuteFunctionWithTokenIsNotValidException() {
        assertThrows(TokenIsNotValidException.class, () -> tokenValidationService.executeIfHasValidToken("invalidToken", null));
    }

}