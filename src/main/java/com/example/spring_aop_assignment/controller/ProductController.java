package com.example.spring_aop_assignment.controller;

import com.example.spring_aop_assignment.entities.Product;
import com.example.spring_aop_assignment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PutMapping
    public Product updateProduct(@RequestParam Long productId, @RequestParam double price, @RequestParam int stock){
        return  productService.updateMyProduct(productId,price,stock);
    }

}
