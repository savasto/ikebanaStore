package com.example.ikebanaStore.service;

import com.example.ikebanaStore.model.OrderItem;
import com.example.ikebanaStore.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemsRepository;

    public Iterable<OrderItem> getAllOrderItems(){
    return orderItemsRepository.findAll();
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemsRepository.save(orderItem);
    }
}





