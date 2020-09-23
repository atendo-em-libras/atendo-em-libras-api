package com.atendoemlibras.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

    ENFERMAGEM("Enfermagem"), FISIOTERAPIA("Fisioterapia"), FONOAUDIOLOGIA("Fonoaudiologia"), MEDICINA("Medicina"),
    NUTRICAO("Nutrição"), ODONTOLOGIA("Odontologia"), PSICOLOGIA("Psicologia"),
    TECNICO_ENFERMAGEM("Técnico em enfermagem"), OUTRO("Outra especialidade");

    private String label;

    private static final Map<CategoryEnum, String> map = new HashMap<>();

    static {
        for (CategoryEnum category : values()) {
            map.put(category, category.label);
        }
    }

    CategoryEnum(String label) {
        this.label = label;
    }

    public static String valueOf(CategoryEnum ordinal) {
        return map.get(ordinal);
    }

}