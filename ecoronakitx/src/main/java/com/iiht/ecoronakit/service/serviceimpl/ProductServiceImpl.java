package com.iiht.ecoronakit.service.serviceimpl;

import com.iiht.ecoronakit.dto.ProductDTO;
import com.iiht.ecoronakit.dto.SuccessResponseDTO;
import com.iiht.ecoronakit.enums.Category;
import com.iiht.ecoronakit.exceptions.ConflictException;
import com.iiht.ecoronakit.exceptions.DataNotFoundException;
import com.iiht.ecoronakit.models.Product;
import com.iiht.ecoronakit.repositories.ProductRepository;
import com.iiht.ecoronakit.service.ProductService;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.iiht.ecoronakit.service.serviceimpl.ProductServiceImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Override
	public String addProduct(ProductDTO dto) {
		return "SUCCESS";
	}

	@Override
	public String uploadProducts(List<ProductDTO> dtos) throws ConflictException {

		return "SUCCESS";
	}

	@Override
	public ProductDTO findProductById(Long productId) {

		return ProductDTO;
	}

	@Override
	public List<ProductDTO> retrieveProducts() {

		return productDTOS;
	}

	@Override
	public String updateProduct(ProductDTO dto, Long productId) throws DataNotFoundException {

		return "SUCCESS";

	}

	@Override
	public String deleteProduct(Long productId) throws DataNotFoundException {

		return "SICCESS";

	}
}
