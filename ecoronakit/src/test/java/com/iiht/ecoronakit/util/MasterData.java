package com.iiht.ecoronakit.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.iiht.ecoronakit.dto.ProductDTO;

public class MasterData {

	public static ProductDTO getProductDTO() {

		ProductDTO product = new ProductDTO();
		product.setCategory("Healthcare");
		product.setProductCost("100");
		product.setProductDescription("Corona Kit");
		product.setProductName("Mask");
		
		
		return product;
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
