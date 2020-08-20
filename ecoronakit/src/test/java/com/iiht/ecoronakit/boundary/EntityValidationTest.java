package com.iiht.ecoronakit.boundary;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.junit4.SpringRunner;


import com.iiht.ecoronakit.dto.ProductDTO;
import com.iiht.ecoronakit.util.MasterData;








@RunWith(SpringRunner.class)
public class EntityValidationTest {
	
	

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testProductSuccess() throws Exception {
		
			ProductDTO details = MasterData.getProductDTO();
			Set<ConstraintViolation<ProductDTO>> violations = validator.validate(details);
			yakshaAssert(currentTest(), 
						 violations.isEmpty()? true : false, 
						 boundaryTestFile);
	}
	
	@Test
	public void testProductNameLength() throws Exception {

		ProductDTO product = MasterData.getProductDTO();
		product.setProductName("Sanitizer");
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(product);
		yakshaAssert(currentTest(), 
					 violations.isEmpty()? true : false, 
					 boundaryTestFile);

	}
	
	@Test
	public void testProductCategory() throws Exception {
		ProductDTO product = MasterData.getProductDTO();
		product.setCategory("Healthcare");
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(product);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);

	}

	

	@Test
	public void testProductCost() throws Exception {
		ProductDTO product = MasterData.getProductDTO();
		product.setProductCost("100");
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(product);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
	@Test
	public void testProductSpecification() throws Exception {
		ProductDTO product = MasterData.getProductDTO();
		product.setProductSpecification("Health product for corona");
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(product);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
	
}