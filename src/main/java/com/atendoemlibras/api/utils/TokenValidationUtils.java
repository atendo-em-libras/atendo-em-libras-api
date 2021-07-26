package com.atendoemlibras.api.utils;

import org.springframework.beans.factory.annotation.Value;

public class TokenValidationUtils {

    @Value("${spring.token.value}")
    private static String profileToken;

    public static boolean isValidToken(String token) {
        return token.equals(profileToken);
    }
}
