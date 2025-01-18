package com.xiu.controller;

import com.xiu.order.entity.Order;
import com.xiu.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class OrderController {

    private final OrderService orderService;

    @Value("${order.timeout}")
    String orderTimeout;
    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    @GetMapping("/config")
    public String config(){
        return "order.timeout="+orderTimeout+": order.auto-confirm="+orderAutoConfirm;
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId){

        return orderService.createOrder(productId, userId);
    }
}
