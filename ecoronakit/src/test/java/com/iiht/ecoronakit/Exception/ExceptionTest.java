package com.iiht.ecoronakit.exception;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.iiht.ecoronakit.controllers.ProductsController;
import com.iiht.ecoronakit.dto.ProductDTO;
import com.iiht.ecoronakit.service.ProductService;
import com.iiht.ecoronakit.service.serviceimpl.ProductServiceImpl;
import com.iiht.ecoronakit.util.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(ProductsController.class)
public class ExceptionTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductServiceImpl productServiceImpl;
	
	@Test
	public void testAddProductException() throws Exception {
		
		ProductDTO badData = MasterData.getProductDTO();
		badData.setCategory("Healthcare");
		badData.setProductName("Sanitizer");;
		when(productServiceImpl.addProduct(MasterData.getProductDTO()))
		.thenReturn(MasterData.getProductDTO());
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/gift-card/addGiftCardOrder")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), 
		exceptionTestFile);
	}
	
	@Test
	public  void testDeleteGiftCardException() throws Exception{
		
		
		when(productServiceImpl.deleteProduct((long) 1)
		.thenReturn(MasterData.getProductDTO()));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteGiftCards/2")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
	}
}
