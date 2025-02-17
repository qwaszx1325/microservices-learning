package com.xiu.feign;

import com.xiu.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product")
public interface ProductFeignClient {

    // 可以直接copy呼叫的controller方法
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id")Long id);
}
