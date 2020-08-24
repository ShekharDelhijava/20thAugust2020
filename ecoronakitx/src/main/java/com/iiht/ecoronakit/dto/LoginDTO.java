package com.iiht.ecoronakit.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
public class LoginDTO {
	
	@Length(min = 5, max = 30)
	@NotNull
    private String username;
	
	@Length(min = 5, max = 30)
	@NotNull
    private String password;

 
}
