package com.iiht.ecoronakit.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.*;

@Data
public class AddressDTO {

	@Length(min = 5, max = 10)
	
	private String postboxNo;
	
	@Length(min = 5, max = 30)
	
	private String landmark;
	
	@Length(min = 5, max = 10)
	@NotNull
	private String zipcode;
	
	@NotNull
	private String phoneNumber;
	
	@Length(min = 5, max = 30)
	@NotNull
	private String city;

	public AddressDTO() {
	}

}
