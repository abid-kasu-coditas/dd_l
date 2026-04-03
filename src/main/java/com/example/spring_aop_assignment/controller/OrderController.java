package com.example.spring_aop_assignment.controller;

 import com.example.spring_aop_assignment.entities.Order;
 import com.example.spring_aop_assignment.service.OrderService;
 import lombok.RequiredArgsConstructor;
 import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam Integer quantity
    ){
        return orderService.placeOrder(userId,productId,quantity);
    }

    @PutMapping("/cancel")
    public Order cancelOrder(@RequestParam Long customerId,@RequestParam Long orderId){
        return orderService.orderCancel(customerId,orderId);
    }


}
