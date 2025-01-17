package com.xiu.service;


import com.xiu.order.entity.Order;

public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
