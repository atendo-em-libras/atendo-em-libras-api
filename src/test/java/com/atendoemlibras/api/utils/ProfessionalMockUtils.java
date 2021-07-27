package com.atendoemlibras.api.utils;

import com.atendoemlibras.api.domain.Professional;

import java.util.Arrays;
import java.util.List;

public class ProfessionalMockUtils {

    public static Professional getProfessionalFromMock(Long id, String name, String email) {
        var professional = new Professional();
        professional.setId(id);
        professional.setName(name);
        professional.setEmail(email);
        return professional;
    }

    public static Professional getProfessionalFromMock(String name, String email) {
        var professional = new Professional();
        professional.setName(name);
        professional.setEmail(email);
        return professional;
    }

    public static Professional getProfessionalFromMock() {
        var professional = new Professional();
        professional.setId(1L);
        professional.setName("Jose");
        professional.setEmail("jose@gmail.com");
        return professional;
    }

    public static List<Professional> getMockProfessionals() {
        var professionalOne = ProfessionalMockUtils.getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");
        var professionalTwo = ProfessionalMockUtils.getProfessionalFromMock(2L, "maria",  "maria@teste.com.br");
        return Arrays.asList(professionalOne, professionalTwo);
    }
}
