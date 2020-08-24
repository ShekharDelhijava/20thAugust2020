package com.iiht.ecoronakit.service;

import java.util.List;

import com.iiht.ecoronakit.models.UserCart;


public interface UserCartService {

    List<UserCart> addItem(List<UserCart> dtos);

    UserCart updateItem(UserCart dto, Long cartId);

    List<UserCart> findAll();

    String deleteById(Long cartId);

}
