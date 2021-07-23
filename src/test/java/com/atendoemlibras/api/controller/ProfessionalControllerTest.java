package com.atendoemlibras.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.service.ProfessionalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ProfessionalControllerTest {

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
		var professionalOne = getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");
		var professionalTwo = getProfessionalFromMock(2L, "maria",  "maria@teste.com.br");
		List<Professional> professionals = Arrays.asList(professionalOne, professionalTwo);

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
		var professional = getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");

		when(professionalService.getOneProfessional(1)).thenReturn(Optional.of(professional));

		var response = professionalController.getOneProfessional(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(professional.getName(), response.getBody().getName());
		assertEquals(professional.getEmail(), response.getBody().getEmail());
	}

	@Test
	void shouldReturnNotFoundProfessionalById() {
		when(professionalService.getOneProfessional(1)).thenReturn(Optional.empty());

		var response = professionalController.getOneProfessional(1);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void shouldReturnCreatedOnProfessionalRegistration() {
		var professional = getProfessionalFromMock(1L, "carol",  "carol@teste.com.br");

		when(professionalService.addProfessional(professional)).thenReturn(1L);

		var response = professionalController.addProfessional(professional, uriBuilder);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(professional.getId(), response.getBody());
	}

	private Professional getProfessionalFromMock(Long id, String name, String email) {
		var professional = new Professional();
		professional.setId(id);
		professional.setName(name);
		professional.setEmail(email);
		return professional;
	}
}
