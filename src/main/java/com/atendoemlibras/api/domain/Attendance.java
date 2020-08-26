package com.atendoemlibras.api.domain;

import com.atendoemlibras.api.domain.AttendanceTypes.HospitalClinicAttendance;
import com.atendoemlibras.api.domain.AttendanceTypes.HouseholdAttendance;
import com.atendoemlibras.api.domain.AttendanceTypes.OnlineAttendance;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "online_attendance_id", referencedColumnName = "id")
    private OnlineAttendance onlineAttendance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_clinic_attendance_id", referencedColumnName = "id")
    private HospitalClinicAttendance hospitalClinicAttendance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "household_attendance_id", referencedColumnName = "id")
    private HouseholdAttendance householdAttendance;

    @JsonCreator
    public Attendance(@JsonProperty("onlineAttendance") OnlineAttendance onlineAttendance,
                      @JsonProperty("hospitalClinicAttendance") HospitalClinicAttendance hospitalClinicAttendance,
                      @JsonProperty("householdAttendance") HouseholdAttendance householdAttendance) {
        this.onlineAttendance = onlineAttendance;
        this.hospitalClinicAttendance = hospitalClinicAttendance;
        this.householdAttendance = householdAttendance;
    }

    @JsonCreator
    public Attendance() {

    }

    public OnlineAttendance getOnlineAttendance() {
        return onlineAttendance;
    }

    public HospitalClinicAttendance getHospitalClinicAttendance() {
        return hospitalClinicAttendance;
    }

    public HouseholdAttendance getHouseholdAttendance() {
        return householdAttendance;
    }
}