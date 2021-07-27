package com.atendoemlibras.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.service.ProfessionalService;
import com.atendoemlibras.api.utils.ProfessionalMockUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

class ProfessionalControllerTest {

	private static final String TOKEN = "devtoken";

	private ProfessionalController professionalController;

	private UriComponentsBuilder uriBuilder;

	@Mock
	private ProfessionalService professionalService;

	@BeforeEach
	public void configure() {
		MockitoAnnotations.openMocks(this);
		professionalController = new ProfessionalController(professionalService);
		uriBuilder = UriComponentsBuilder.fromUriString("http://localhost:8080");
	}

	@Test
	void shouldReturnProfessionalsWithSuccess() {
		List<Professional> professionals = ProfessionalMockUtils.getMockProfessionals();
		when(professionalService.getAll()).thenReturn(professionals);

		var response = professionalController.getAll();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(professionals.size(), response.getBody().size());

		for (int i = 0; i < professionals.size(); i++) {
			assertEquals(professionals.get(i).getName(), response.getBody().get(i).getName());
			assertEquals(professionals.get(i).getEmail(), response.getBody().get(i).getEmail());
		}
	}

	@Test
	void shouldReturnEmptyProfessionals() {
		when(professionalService.getAll()).thenReturn(new ArrayList<>());
		var response = professionalController.getAll();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().isEmpty());
	}

	@Test
	void shouldReturnOkProfessionalById() {
		var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");
		when(professionalService.getProfessionalById(1L)).thenReturn(professional);

		var response = professionalController.getOneProfessional(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(professional.getName(), response.getBody().getName());
		assertEquals(professional.getEmail(), response.getBody().getEmail());
	}

	@Test
	void shouldReturnNotFoundProfessionalById() {
		doThrow(ProfessionalNotFoundException.class).when(professionalService).getProfessionalById(anyLong());
		assertThrows(ProfessionalNotFoundException.class, () -> professionalController.getOneProfessional(1L));
	}

	@Test
	void shouldReturnCreatedOnProfessionalRegistration() {
		var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");
		when(professionalService.addProfessional(professional)).thenReturn(professional);

		var response = professionalController.addProfessional(professional, uriBuilder);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());

		var professionalResponse = response.getBody();
		assertEquals(professional.getId(), professionalResponse.getId());
		assertEquals(professional.getName(), professionalResponse.getName());
		assertEquals(professional.getEmail(), professionalResponse.getEmail());
	}

	@Test
	void shouldUpdateProfessionalWithSuccess() {
		var professional = ProfessionalMockUtils.getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");
		when(professionalService.updateProfessional(1L, TOKEN, professional)).thenReturn(professional);

		var response = professionalController.updateProfessional(1L, TOKEN, professional);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(professional.getId(), response.getBody().getId());
	}

	@Test
	void shouldDeleteProfessionalWithSuccess() {
		doNothing().when(professionalService).deleteProfessional(anyLong(), anyString());
		var response = professionalController.deleteProfessional(1L, TOKEN);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
}
