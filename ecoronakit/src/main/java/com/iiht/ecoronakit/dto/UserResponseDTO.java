package com.iiht.ecoronakit.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponseDTO {

    private long userId;

    private String firstName;

    private String lastName;

    private String username;

//    private String password;

    private String email;

    private AddressDTO address;

    private String role;

}
