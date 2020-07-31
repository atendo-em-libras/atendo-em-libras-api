package com.atendoemlibras.api.repository;

import com.atendoemlibras.api.domain.Professional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProfessionalRepository {
    private static ArrayList<Professional> professionalList = new ArrayList<>(Arrays.asList(new Professional("Maria"), new Professional("Juliana")));

    public List<Professional> getAll() {
        return professionalList;
    }

    public void addProfessional(Professional professional) {
        professionalList.add(professional);
    }

    public void deleteProfessional(int index) {
        professionalList.remove(index);
    }

}
