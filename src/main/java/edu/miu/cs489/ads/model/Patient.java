package edu.miu.cs489.ads.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  patient_id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate date_of_birth;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    @OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;


}
