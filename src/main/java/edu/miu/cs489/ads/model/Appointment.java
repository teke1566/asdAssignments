package edu.miu.cs489.ads.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id;
    private Date AppointmentDate;
    private Timestamp AppointmentTime;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="surgery_id")
    private Surgery surgery;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
}
