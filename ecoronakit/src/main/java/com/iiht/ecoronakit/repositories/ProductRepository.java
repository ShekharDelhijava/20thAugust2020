package com.iiht.ecoronakit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.ecoronakit.models.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
