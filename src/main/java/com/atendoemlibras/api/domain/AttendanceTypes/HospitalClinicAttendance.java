package com.atendoemlibras.api.domain.AttendanceTypes;

import com.atendoemlibras.api.domain.Attendance;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "hospital_clinic_attendances")
public class HospitalClinicAttendance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "hospitalClinicAttendance")
    private Attendance attendance;

    @Column(name = "cep")
    private String CEP;

    private String state;
    private String stateInitials;
    private String city;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "complement_info")
    private String complementInfo;

    private String name;
    private String phone;
    private String email;

    @JsonCreator
    public HospitalClinicAttendance(@JsonProperty("CEP") String CEP,
                                    @JsonProperty("state") String state,
                                    @JsonProperty("stateInitials") String stateInitials,
                                    @JsonProperty("city") String city,
                                    @JsonProperty("streetName") String streetName,
                                    @JsonProperty("streetNumber") String streetNumber,
                                    @JsonProperty("complementInfo") String complementInfo,
                                    @JsonProperty("name") String name,
                                    @JsonProperty("phone") String phone,
                                    @JsonProperty("email") String email) {
        this.CEP = CEP;
        this.state = state;
        this.stateInitials = stateInitials;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.complementInfo = complementInfo;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @JsonCreator
    public HospitalClinicAttendance(){

    }
}
