package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import com.atendoemlibras.api.utils.ProfessionalMockUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProfessionalServiceTest {

    private ProfessionalService professionalService;

    @Mock
    private ProfessionalRepository repository;

    @Mock
    private TokenValidationService tokenValidationService;

    @BeforeEach
    void configure() {
        MockitoAnnotations.openMocks(this);

        professionalService = new ProfessionalService(repository, tokenValidationService);
    }

    @Test
    void shouldReturnListOfProfessionals() {
        var professionals = ProfessionalMockUtils.getMockProfessionals();

        when(repository.findAll()).thenReturn(professionals);

        var response = professionalService.getAll();

        for (int i = 0; i < professionals.size(); i++) {
            assertEquals(professionals.get(i).getName(), response.get(i).getName());
            assertEquals(professionals.get(i).getEmail(), response.get(i).getEmail());
        }
    }

    @Test
    void shouldReturnEmptyListOfProfessionals() {
        when(repository.findAll()).thenReturn(new ArrayList<Professional>());

        var response = professionalService.getAll();
        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnProfessionalOnSave() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock("Jose", "ze@gmail.com");
        var professionalOnSave = ProfessionalMockUtils.getProfessionalFromMock(1L, professional.getName(), professional.getEmail());

        when(repository.save(any(Professional.class))).thenReturn(professionalOnSave);

        var response = professionalService.addProfessional(professional);
        assertEquals(1L, response.getId());
        assertEquals(professional.getName(), response.getName());
        assertEquals(professional.getEmail(), response.getEmail());
    }

}