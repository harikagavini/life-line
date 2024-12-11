package org.lifeline.controllers;

import org.lifeline.dto.OrderDTO;
import org.lifeline.model.Order;
import org.lifeline.response.OrderResponse;
import org.lifeline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeline/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public OrderResponse createOrder(@RequestBody Order order){
        orderService.saveOrder(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setMessage("Order Created");
        orderResponse.setSuccess(true);
        return orderResponse;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{order_id}")
    public OrderResponse updateOrder(@RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderDTO);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setMessage("Order Updated");
        orderResponse.setSuccess(true);
        return orderResponse;

    }
}

