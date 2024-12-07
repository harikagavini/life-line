package org.lifeline.service;

import org.lifeline.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();
    public Order createOrder(String hosp_id, String branch_id, String blood_type, int quantity);    public Order getOrderById(Long order_id);
    public List<Order> getOrderByStatus(String status);
    public Order updateOrder(Long order_id, String hosp_id, String branch_id, String blood_type, int quantity, String status);
        public boolean deleteOrder(Long order_id);
}
