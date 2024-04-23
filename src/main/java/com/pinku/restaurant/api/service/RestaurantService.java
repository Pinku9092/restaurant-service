package com.pinku.restaurant.api.service;

import com.pinku.restaurant.api.dao.RestaurantOrderDAO;
import com.pinku.restaurant.api.dto.OrderResponseDTO;
import com.pinku.restaurant.api.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantOrderDAO orderDAO;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        OrderResponseDTO orderResponseDTO = orderDAO.getOrders(orderId);
        if (orderResponseDTO != null) {
            return orderResponseDTO;
        } else {
            throw new OrderNotFoundException("Order not available with id :" + orderId);
        }
    }
}