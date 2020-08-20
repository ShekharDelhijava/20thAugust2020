package com.iiht.ecoronakit.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.iiht.ecoronakit.enums.Role;

import java.util.List;


@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductOrder> orders;


}
