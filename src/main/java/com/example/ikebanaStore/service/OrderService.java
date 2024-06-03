package com.example.ikebanaStore.service;

import com.example.ikebanaStore.model.Order;
import com.example.ikebanaStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Iterable<Order> getAllOrders(){

    return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
