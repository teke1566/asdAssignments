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
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  surgery_id;
    private  String name;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointmentList;



}
