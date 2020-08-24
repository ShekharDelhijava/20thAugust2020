package com.iiht.ecoronakit.service.serviceimpl;

import com.iiht.ecoronakit.models.ProductOrder;
import com.iiht.ecoronakit.service.OrderService;

import java.util.List;


public class OrderServiceImpl implements OrderService {

    @Override
    public ProductOrder placeOrder(ProductOrder dto) {
        return null;
    }

    @Override
    public ProductOrder findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<ProductOrder> findByUserId(Long userId) {
        return null;
    }

    @Override
    public ProductOrder updateOrder(ProductOrder dto, Long orderId) {
        return null;
    }

    @Override
    public String cancelOrder(Long orderId) {
        return null;
    }
}
