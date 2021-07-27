package com.atendoemlibras.api.validation;

import com.atendoemlibras.api.exceptions.ExceptionResponse;
import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.exceptions.TokenIsNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfessionalNotFoundException.class)
    public ExceptionResponse handle(ProfessionalNotFoundException exception) {
        return new ExceptionResponse(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TokenIsNotValidException.class)
    public ExceptionResponse handle(TokenIsNotValidException exception) {
        return new ExceptionResponse(exception.getMessage());
    }
}
