package com.iiht.ecoronakit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.ecoronakit.models.UserCart;


public interface UserCartRepository extends JpaRepository<UserCart, Long> {
}
