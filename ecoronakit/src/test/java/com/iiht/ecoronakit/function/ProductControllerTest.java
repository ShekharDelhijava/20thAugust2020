package com.iiht.ecoronakit.functional;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class ProductControllerTest {

	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductServiceImpl productrServiceImpl;

	@Test
	public void testAddProduct() throws Exception {
		when(productrServiceImpl.addProduct(MasterData.getProductDTO()))
		.thenReturn(com.iiht.ecoronakit.util.MasterData.getProductDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addProduct")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	
	
	@Test
	public void testViewAllOrders() throws Exception {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		list.add(MasterData.getProductDTO());
		when(productrServiceImpl.retrieveProducts())
		.thenReturn(list);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewAllOrders")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test
	public  void testDeleteProduct() throws Exception{
		
		
		when(productrServiceImpl.deleteProduct(long)1)
		.thenReturn(MasterData.getProductDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteProduct/1")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test
	public  void testUpdate() throws Exception{
		
		when(productrServiceImpl.updateProduct(MasterData.getProductDTO()))
		.thenReturn(MasterData.getProductDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateProduct")
				.content(MasterData.asJsonString(MasterData.getProductDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}

}