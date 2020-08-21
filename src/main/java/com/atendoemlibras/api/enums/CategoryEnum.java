package com.atendoemlibras.api.enums;

public enum CategoryEnum {

    ENFERMAGEM("Enfermagem"),
    FISIOTERAPIA("Fisioterapia"),
    FONOAUDIOLOGIA("Fonoaudiologia"),
    MEDICINA("Medicina"),
    NUTRICAO("Nutrição"),
    ODONTOLOGIA("Odontologia"),
    PSICOLOGIA("Psicologia"),
    TECNICO_ENFERMAGE("Técnico em enfermagem");

    private String value;

    CategoryEnum(String value){
        this.value = value;
    }
}