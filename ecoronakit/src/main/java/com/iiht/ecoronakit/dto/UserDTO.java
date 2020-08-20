package com.iiht.ecoronakit.dto;

import lombok.*;


@Data
public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private AddressDTO addresses;

    private String role;

    public  UserDTO(){}
}
