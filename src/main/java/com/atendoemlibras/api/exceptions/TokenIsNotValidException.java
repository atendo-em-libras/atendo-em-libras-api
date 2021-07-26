package com.atendoemlibras.api.exceptions;

public class TokenIsNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TokenIsNotValidException(String message){
        super(message);
    }

}
