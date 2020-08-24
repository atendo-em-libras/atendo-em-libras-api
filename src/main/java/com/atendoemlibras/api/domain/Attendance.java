package com.atendoemlibras.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attendances")
public class  Attendance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "attendance")
    private Professional professional;

    @JsonCreator
    public Attendance() {
    }
}