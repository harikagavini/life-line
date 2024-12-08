package org.lifeline.controllers;

import org.lifeline.model.Order;
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
    public ResponseEntity<Order> createOrder(@RequestParam String hosp_id,
                                             @RequestParam String branch_id,
                                             @RequestParam String blood_type,
                                             @RequestParam int quantity) {
        Order order = orderService.createOrder(hosp_id, branch_id, blood_type, quantity);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String status) {
        List<Order> orders = orderService.getOrderByStatus(status);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{order_id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long order_id,
                                             @RequestParam String hosp_id,
                                             @RequestParam String branch_id,
                                             @RequestParam String blood_type,
                                             @RequestParam int quantity,
                                             @RequestParam String status) {
        Order updatedOrder = orderService.updateOrder(order_id, hosp_id, branch_id, blood_type, quantity, status);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}

