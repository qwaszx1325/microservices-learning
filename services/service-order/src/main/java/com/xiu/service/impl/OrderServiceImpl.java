package com.xiu.service.impl;

import com.xiu.order.entity.Order;
import com.xiu.product.entity.Product;
import com.xiu.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private  final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductFromRemot(productId);
        Order order = new Order();
        order.setId(1L);

        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("胖胖");
        order.setAddress("xiu");

        order.setProductList(Arrays.asList(product));

        return order;
    }

    private Product getProductFromRemot(Long productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("遠程調用請求: {}",url);
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }

}
