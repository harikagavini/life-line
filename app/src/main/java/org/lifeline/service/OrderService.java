package org.lifeline.service;

import org.lifeline.dto.OrderDTO;
import org.lifeline.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public Order saveOrder(Order order);

    public Order updateOrder(OrderDTO orderDTO);
}