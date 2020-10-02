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

    @Column(name = "state_initials")
    private String stateInitials;

    private String city;
    private String email;

    @JsonCreator
    public HouseholdAttendance(@JsonProperty("state") String state,
                               @JsonProperty("stateInitials") String stateInitials,
                               @JsonProperty("city") String city,
                               @JsonProperty("email") String email) {
        this.state = state;
        this.stateInitials = stateInitials;
        this.city = city;
        this.email = email;
    }

    @JsonCreator
    public HouseholdAttendance() {

    }

    public String getState() {
        return state;
    }

    public String getStateInitials() {
        return stateInitials;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
