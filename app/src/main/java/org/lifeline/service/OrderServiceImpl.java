package org.lifeline.service;

import org.lifeline.dto.OrderDTO;
import org.lifeline.model.Events;
import org.lifeline.model.Order;
import org.lifeline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {

        if(order.getBranchId()== null || order.getHospId() == null || order.getBloodType() == null || order.getQuantity() == 0){
            throw new IllegalArgumentException("Required details must be filled");
        }

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(OrderDTO orderDTO){
        Optional<Order> order = orderRepository.findById(orderDTO.getOrderId());

        if(order.isPresent()) {

            Order updateOrder = order.get();
            updateOrder.setQuantity(orderDTO.getQuantity());
            updateOrder.setBloodType(orderDTO.getBloodType());
            updateOrder.setStatus(orderDTO.getStatus());
            updateOrder.setBranchId(orderDTO.getBranchId());
            return orderRepository.save(updateOrder);
        }
        return null;
    }
}
