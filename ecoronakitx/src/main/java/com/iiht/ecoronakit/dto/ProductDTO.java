package com.iiht.ecoronakit.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {

	@Length(min = 5, max = 30)
	@NotNull
    private String productName;
	
	@Length(min = 5, max = 30)
	@NotNull
    private String productCost;
	
	@Length(min = 5, max = 50)
	@NotNull
    private String productDescription;
	
	@Length(min = 5, max = 30)
	@NotNull
    private String productSpecification;
	
	@Length(min = 2, max = 20)
	@NotNull
    private String category;
	
	
}
