package com.xiu.service.impl;

import com.xiu.product.entity.Product;
import com.xiu.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service

public class ProductServiceImpl implements ProductService {


    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setProductName("蘋果");
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setNum(2);

//        System.out.println("test");
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return product;
    }
}
