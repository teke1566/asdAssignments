package edu.miu.cs489.ads.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentist_id;
    private String firstName;
    private String lastName;
    private String email;
    private  String specialization;
    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointmentList;


}
