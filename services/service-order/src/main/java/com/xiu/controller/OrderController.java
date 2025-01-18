package com.xiu.controller;

import com.xiu.order.entity.Order;
import com.xiu.properties.OrderProperties;
import com.xiu.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderProperties orderProperties;


    @GetMapping("/config")
    public String config(){
        String timeout = orderProperties.getTimeout();
        String autoConfirm = orderProperties.getAutoConfirm();
        return "order.timeout="+timeout+": order.auto-confirm="+autoConfirm;
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId){

        return orderService.createOrder(productId, userId);
    }
}
