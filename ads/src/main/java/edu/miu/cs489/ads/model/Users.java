package edu.miu.cs489.ads.model;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address_id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

}
