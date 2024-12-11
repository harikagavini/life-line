package org.lifeline.service;

import org.lifeline.model.Order;
import org.lifeline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order createOrder(String hosp_id, String branch_id, String blood_type, int quantity) {
        Order order = new Order();
        order.setHospId(hosp_id);
        order.setBranchId(branch_id);
        order.setBloodType(blood_type);
        order.setQuantity(quantity);
        order.setStatus("Pending");  // Initial status is Pending
        order.setOrderCreated(new Date());  // Set order creation time
        order.setOrderCompleted(null);  // Order is not completed initially

        return orderRepo.save(order);  // Save and return the created order
    }

    @Override
    public Order getOrderById(Long order_id) {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }
    @Override
    public List<Order> getOrderByStatus(String status) {
        return orderRepo.findByStatus(status);
    }
    @Override
    public Order updateOrder(Long order_id, String hosp_id, String branch_id, String blood_type, int quantity, String status) {
        Optional<Order> optionalOrder = orderRepo.findById(order_id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setHospId(hosp_id);
            order.setBranch_id(branch_id);
            order.setBlood_type(blood_type);
            order.setQuantity(quantity);
            order.setStatus(status);  // Update status
            order.setOrder_completed(status.equals("Completed") ? new Date() : order.getOrder_completed());  // Set completion date if status is 'Completed'

            return orderRepo.save(order);
        } else {
            throw new RuntimeException("Order not found with ID: " + order_id);
        }
    }
    @Override
    public boolean deleteOrder(Long order_id) {
        if (orderRepo.existsById(order_id)) {
            orderRepo.deleteById(order_id);
            return true;
        } else {
            return false;
        }
    }
}
