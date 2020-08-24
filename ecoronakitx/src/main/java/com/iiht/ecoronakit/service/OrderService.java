package com.iiht.ecoronakit.service;

import java.util.List;

import com.iiht.ecoronakit.models.ProductOrder;


public interface OrderService {

    ProductOrder placeOrder(ProductOrder dto);

    ProductOrder findByOrderId(Long orderId);

    List<ProductOrder> findByUserId(Long userId);

    ProductOrder updateOrder(ProductOrder dto, Long orderId);

    String cancelOrder(Long orderId);

}
