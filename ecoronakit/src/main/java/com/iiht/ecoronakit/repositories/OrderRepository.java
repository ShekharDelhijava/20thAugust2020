package com.iiht.ecoronakit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.ecoronakit.models.ProductOrder;


public interface OrderRepository extends JpaRepository<ProductOrder,Long> {
}
