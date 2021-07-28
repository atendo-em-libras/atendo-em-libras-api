package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.exceptions.TokenIsNotValidException;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import com.atendoemlibras.api.utils.ProfessionalMockUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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

    @Test
    void shouldReturnProfessionalById() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "Jose", "ze@gmail.com");

        when(repository.findById(anyLong())).thenReturn(Optional.of(professional));

        var response = professionalService.getProfessionalById(1L);
        assertEquals(professional.getId(), response.getId());
        assertEquals(professional.getName(), response.getName());
        assertEquals(professional.getEmail(), response.getEmail());
    }

    @Test
    void shouldThrowProfessionalNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ProfessionalNotFoundException.class, () -> professionalService.getProfessionalById(1L));
    }

    @Test
    void shouldDeleteProfessionalById() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "Jose", "ze@gmail.com");

        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            return invocation.getArgument(1, Supplier.class).get();
        });

        when(repository.findById(anyLong())).thenReturn(Optional.of(professional));

        doNothing().when(repository).delete(any());

        professionalService.deleteProfessional(1L, "devtoken");

        verify(repository).findById(anyLong());
        verify(repository).delete(any());
    }

    @Test
    void shouldDeleteProfessionalNotFound() {
        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            return invocation.getArgument(1, Supplier.class).get();
        });

        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ProfessionalNotFoundException.class, () -> professionalService.deleteProfessional(1L, "devtoken"));

        verify(tokenValidationService).executeIfHasValidToken(anyString(), any());
        verify(repository, never()).delete(any());
    }

    @Test
    void shouldNotDeleteProfessionalTokenIsNotValidException() {
        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            throw new TokenIsNotValidException("Token nao valido");
        });

        assertThrows(TokenIsNotValidException.class, () -> professionalService.deleteProfessional(1L, "devtoken"));

        verify(tokenValidationService).executeIfHasValidToken(anyString(), any());
        verify(repository, never()).findById(any());
        verify(repository, never()).delete(any());
    }

    @Test
    void shouldUpdateProfessionalById() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "Jose", "ze@gmail.com");

        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            return invocation.getArgument(1, Supplier.class).get();
        });

        when(repository.findById(anyLong())).thenReturn(Optional.of(professional));

        when(repository.save(any())).thenReturn(professional);

        var response = professionalService.updateProfessional(1L, "devtoken", professional);
        assertEquals(professional.getId(), response.getId());
        assertEquals(professional.getName(), response.getName());
        assertEquals(professional.getEmail(), response.getEmail());
    }

    @Test
    void shouldUpdateProfessionalNotFound() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock();

        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            return invocation.getArgument(1, Supplier.class).get();
        });

        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ProfessionalNotFoundException.class, () -> professionalService.updateProfessional(1L, "devtoken", professional));

        verify(tokenValidationService).executeIfHasValidToken(anyString(), any());
        verify(repository, never()).save(any());
    }

    @Test
    void shouldNotUpdateProfessionalTokenIsNotValidException() {
        var professional = ProfessionalMockUtils.getProfessionalFromMock();

        when(tokenValidationService.executeIfHasValidToken(anyString(), any())).then(invocation -> {
            throw new TokenIsNotValidException("Token nao valido");
        });

        assertThrows(TokenIsNotValidException.class, () -> professionalService.updateProfessional(1L, "devtoken", professional));

        verify(tokenValidationService).executeIfHasValidToken(anyString(), any());
        verify(repository, never()).findById(any());
        verify(repository, never()).save(any());
    }

}