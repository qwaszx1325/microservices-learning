package com.xiu.controller;

import com.xiu.product.entity.Product;
import com.xiu.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId, HttpServletRequest request){
        String header = request.getHeader("X-Token");
        System.out.println(header);

        Product productById = productService.getProductById(productId);
        return productById;
    }


}
