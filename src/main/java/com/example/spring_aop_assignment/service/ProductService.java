package com.example.spring_aop_assignment.service;

import com.example.spring_aop_assignment.entities.Customer;
import com.example.spring_aop_assignment.entities.Product;
import com.example.spring_aop_assignment.repository.CustomerRepository;
import com.example.spring_aop_assignment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public Product updateMyProduct(Long productId,double price,int stock){
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("PRODUCT NOT FOUND"));

        product.setPrice(BigDecimal.valueOf(price));
        product.setStock(stock);

        return productRepository.save(product);

    }


}
