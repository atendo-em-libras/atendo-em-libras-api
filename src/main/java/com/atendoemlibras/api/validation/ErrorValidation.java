package com.atendoemlibras.api.validation;

public class ErrorValidation {

    private String field;

    private String error;

    public ErrorValidation(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
