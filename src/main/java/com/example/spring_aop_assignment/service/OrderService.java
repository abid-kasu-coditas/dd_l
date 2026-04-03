package com.example.spring_aop_assignment.service;

import com.example.spring_aop_assignment.entities.Customer;
import com.example.spring_aop_assignment.entities.Order;
import com.example.spring_aop_assignment.entities.Product;
import com.example.spring_aop_assignment.repository.CustomerRepository;
import com.example.spring_aop_assignment.repository.OrderRepository;
import com.example.spring_aop_assignment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order placeOrder(Long userId, Long productId, Integer quantity) {

        Customer customer = customerRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not foundnd"));

        if(product.getStock()<quantity){
            throw  new RuntimeException("Less Stock");
        }
        product.setStock(product.getStock()-quantity);

        Order order = Order.builder().customer(customer).product(product).quantity(quantity).totalAmount(product.getPrice()).orderStatus("CREATED").build();

        return orderRepository.save(order);
    }

    public Order orderCancel(Long customerId,Long orderId){
        Order order = orderRepository.findById(customerId).orElseThrow(()-> new RuntimeException("CUSTOMER NOT FOUND"));
        order.setOrderStatus("CANCELLED");
      return orderRepository.save(order);
    }
}
