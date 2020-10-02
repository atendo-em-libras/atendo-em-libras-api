package com.atendoemlibras.api.domain.AttendanceTypes;

import com.atendoemlibras.api.domain.Attendance;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "online_attendances")
public class OnlineAttendance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "onlineAttendance")
    private Attendance attendance;

    @Column(name = "whats_app_number")
    private String whatsAppNumber;

    @Column(name = "platforms")
    private String platforms;

    @Column(name = "has_online_attendance")
    private boolean hasOnlineAttendance;

    @JsonCreator
    public OnlineAttendance(@JsonProperty("whatsAppNumber") String whatsAppNumber,
                            @JsonProperty("platforms") String platforms,
                            @JsonProperty("hasOnlineAttendance") boolean hasOnlineAttendance) {
        this.whatsAppNumber = whatsAppNumber;
        this.platforms = platforms;
        this.hasOnlineAttendance = hasOnlineAttendance;
    }

    @JsonCreator
    public OnlineAttendance() {

    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public String getPlatforms() {
        return platforms;
    }

    public boolean getHasOnlineAttendance() {
        return hasOnlineAttendance;
    }
}
