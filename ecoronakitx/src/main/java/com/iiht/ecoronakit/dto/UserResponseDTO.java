package com.iiht.ecoronakit.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data

public class UserResponseDTO {

	@Length(min = 5, max = 150)
	@NotNull
    private long userId;
	
	@Length(min = 5, max = 30)
	@NotNull
    private String firstName;
	
	@Length(min = 5, max = 30)
    private String lastName;
	
	@Length(min = 5, max = 50)
	@NotNull
    private String username;
	
	@Length(min = 5, max = 30)
	@NotNull
    private String email;
	
	@Length(min = 5, max = 20)
	@NotNull
    private AddressDTO address;
	
	@Length(min = 5, max = 10)
	@NotNull
    private String role;

}
