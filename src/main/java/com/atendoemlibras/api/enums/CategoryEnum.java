package com.atendoemlibras.api.enums;

public enum CategoryEnum {

    ENFERMAGEM("Enfermagem"),
    FISIOTERAPIA("Fisioterapia"),
    FONOAUDIOLOGIA("Fonoaudiologia"),
    MEDICINA("Medicina"),
    NUTRICAO("Nutrição"),
    ODONTOLOGIA("Odontologia"),
    PSICOLOGIA("Psicologia"),
    TECNICO_ENFERMAGEM("Técnico em enfermagem"),
    OUTRO("Outra especialidade");

    private String value;

    CategoryEnum(String value){
        this.value = value;
    }
}