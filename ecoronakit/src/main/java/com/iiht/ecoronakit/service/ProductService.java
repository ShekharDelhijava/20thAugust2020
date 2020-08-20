package com.iiht.ecoronakit.service;

import com.iiht.ecoronakit.dto.ProductDTO;
import com.iiht.ecoronakit.exceptions.ConflictException;
import com.iiht.ecoronakit.exceptions.DataNotFoundException;
import com.iiht.ecoronakit.models.Product;

import java.util.List;


public interface ProductService {

    String addProduct(ProductDTO dto);

    String uploadProducts(List<ProductDTO> products) throws ConflictException;

    ProductDTO findProductById(Long productId);

    List<ProductDTO> retrieveProducts();

    String updateProduct(ProductDTO dto, Long productId) throws DataNotFoundException;

    String deleteProduct(Long productId) throws DataNotFoundException;
}
