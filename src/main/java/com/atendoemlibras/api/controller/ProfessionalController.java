package com.atendoemlibras.api.controller;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.service.ProfessionalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    private ProfessionalService service;

    public ProfessionalController(ProfessionalService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public List<Professional> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{index}")
    public Professional getOneProfessional(@PathVariable("index") int index) {
        return service.getOneProfessional(index);
    }

    @PostMapping(path = "/")
    public void addProfessional(@RequestBody Professional professional){
        service.addProfessional(professional);
    }

    @DeleteMapping(path = "/{index}")
    public void deleteProfessional(@PathVariable("index") int index) {
        service.deleteProfessional(index);
    }
}