package org.lifeline.service;

import org.lifeline.dto.OrderDTO;
import org.lifeline.enums.StatusType;
import org.lifeline.model.BloodBank;
import org.lifeline.model.Order;
import org.lifeline.repository.BloodBankRepository;
import org.lifeline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Override
    public Order saveOrder(Order order) {

        if(order.getBranchId()== null || order.getHospitalId() == null || order.getBloodType() == null || order.getQuantity() == 0){
            throw new IllegalArgumentException("Required details must be filled");
        }

        BloodBank bloodBankEntry = bloodBankRepository.findByBranchId(order.getBranchId());
        if(bloodBankEntry == null) {
            throw  new IllegalArgumentException("Invalid blood bank id");
        }

        order.setOrderCreated(new Date());
        order.setStatus(StatusType.PENDING);

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
            Order updatedOrder = order.get();
            if(orderDTO.getStatus()) {
                updatedOrder.setStatus(StatusType.COMPLETED);
                updatedOrder.setOrderCompleted(new Date());
            } else {
                updatedOrder.setStatus(StatusType.CANCELLED);
                updatedOrder.setOrderCompleted(new Date());
            }

            return orderRepository.save(updatedOrder);
        }
        return null;
    }
}
