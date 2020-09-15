package com.atendoemlibras.api.domain;

import com.atendoemlibras.api.enums.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "professionals")
public class Professional {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String biography;
    private CategoryEnum category;
    private String specialty;

    @Column(name = "register_number")
    private String registerNumber;

    @Column(name = "health_insurance")
    private String healthInsurance;

    @Column(name = "is_referred")
    private boolean isReferred;

    @Column(name = "terms_and_conditions")
    private boolean termsAndCoditions;

    @Column(name = "admin_approved")
    private boolean adminApproved;

    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendance_id", referencedColumnName = "id")
    private Attendance attendance;

    @JsonCreator
    public Professional(@JsonProperty("name") String name, @JsonProperty("biography") String biography,
            @JsonProperty("category") CategoryEnum category, @JsonProperty("specialty") String specialty,
            @JsonProperty("registerNumber") String registerNumber,
            @JsonProperty("healthInsurance") String healthInsurance,
            @JsonProperty("termsAndCoditions") boolean termsAndCoditions, @JsonProperty("email") String email,
            @JsonProperty("phone") String phone, @JsonProperty("attendance") Attendance attendance) {
        this.name = name;
        this.biography = biography;
        this.category = category;
        this.specialty = specialty;
        this.registerNumber = registerNumber;
        this.healthInsurance = healthInsurance;
        this.termsAndCoditions = termsAndCoditions;
        this.email = email;
        this.phone = phone;
        this.attendance = attendance;
    }

    @JsonCreator
    public Professional() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public boolean isReferred() {
        return isReferred;
    }

    public boolean isTermsAndCoditions() {
        return termsAndCoditions;
    }

    public boolean isAdminApproved() {
        return adminApproved;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Attendance getAttendance() {
        return attendance;
    }
}
