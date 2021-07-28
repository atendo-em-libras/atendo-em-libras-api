package com.atendoemlibras.api.service;

import com.atendoemlibras.api.exceptions.TokenIsNotValidException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class TokenValidationService {

    @Value("${spring.token.value}")
    private String profileToken;

    private static final String TOKEN_IS_NOT_VALID = "Token não é válido";

    public TokenValidationService(String profileToken) {
        this.profileToken = profileToken;
    }

    private boolean isValidToken(String token) {
        return token.equals(profileToken);
    }

    public <T1> T1 executeIfHasValidToken(String token, Supplier<T1> execution) {
        if (isValidToken(token)) {
            return execution.get();
        }

        throw new TokenIsNotValidException(TOKEN_IS_NOT_VALID);
    }
}
