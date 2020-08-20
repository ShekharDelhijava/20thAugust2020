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
        Product product = dozerBeanMapper.map(dto, Product.class);
        productRepository.save(product);
        return "SUCCESS";
    }

    @Override
    public String uploadProducts(List<ProductDTO> dtos) throws ConflictException {
        for (ProductDTO dto: dtos) {
            try{
                Product product = dozerBeanMapper.map(dto, Product.class);
                productRepository.save(product);
            }
            catch (DataIntegrityViolationException e){
                throw new ConflictException("Duplicate Product Barcode");
            }
        };
        return "SUCCESS";
    }

    @Override
    public ProductDTO findProductById(Long productId) {

        Product product = productRepository.findById(productId);

        ProductDTO productDTO = dozerBeanMapper.map(product, ProductDTO.class);

        return productDTO;
    }

    @Override
    public List<ProductDTO> retrieveProducts() {

        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product: products) {
            productDTOS.add(dozerBeanMapper.map(product, ProductDTO.class));
        }

        return productDTOS;
    }

    @Override
    public String updateProduct(ProductDTO dto, Long productId) throws DataNotFoundException {

        Product product = productRepository.findOne(productId);

        if(product != null) {
            product.setProductName(dto.getProductName());
            product.setBarcode(dto.getBarcode());
            product.setCategory(Category.valueOf(dto.getCategory()));
            product.setProductCost(dto.getProductCost());
         //   product.setProductImage(dto.getProductImage());
            product.setProductDescription(dto.getProductDescription());
            product.setProductSpecification(dto.getProductSpecification());
            productRepository.flush();

            return "SUCCESS";
        } else {
            throw new DataNotFoundException("Product Not Found");
        }
    }

    @Override
    public String deleteProduct(Long productId) throws DataNotFoundException {

        Product product = productRepository.findOne(productId);

        if(product != null){
            productRepository.delete(product);
            return "SUCCESS";
        } else {
            throw  new DataNotFoundException("Product Not Found");
        }



    }
}
