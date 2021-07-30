package com.atendoemlibras.api.domain;

import com.atendoemlibras.api.enums.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "professionals")
public class Professional {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull(message = "O nome do profissional é obrigatório")
    @Size(min = 1, max = 255, message = "O nome do profissional deve ter entre 1 e 255 caracteres")
    private String name;

    @NotNull(message = "A categoria do profissional deve ser obrigatória")
    private CategoryEnum category;

    @NotNull(message = "O email do profissional é obrigatório")
    @Size(min = 1, max = 255, message = "O email do profissional deve ter entre 1 e 255 caracteres")
    private String email;

    @NotNull(message = "O telefone do profissional é obrigatório")
    @Size(min = 1, max = 255, message = "O nome do profissional deve ter entre 1 e 255 caracteres")
    private String phone;

    private String biography;

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

    public String getCategory() {
        return CategoryEnum.valueOf(category);
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){ this.name = name;}

    public void setEmail(String email) { this.email = email;}
}
