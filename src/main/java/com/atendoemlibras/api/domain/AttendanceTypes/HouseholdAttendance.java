package com.atendoemlibras.api.domain.AttendanceTypes;

import com.atendoemlibras.api.domain.Attendance;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "household_attendances")
public class HouseholdAttendance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "householdAttendance")
    private Attendance attendance;

    private String state;
    private String city;
    private String email;

    @JsonCreator
    public HouseholdAttendance(@JsonProperty("state") String state,
                               @JsonProperty("city") String city,
                               @JsonProperty("email") String email) {
        this.state = state;
        this.city = city;
        this.email = email;
    }

    @JsonCreator
    public HouseholdAttendance() {

    }

    public Attendance getAttendance() {
        return attendance;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
