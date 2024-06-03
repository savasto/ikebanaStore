package com.example.ikebanaStore.controller;


import com.example.ikebanaStore.model.OrderItem;
import com.example.ikebanaStore.repository.OrderItemRepository;
import com.example.ikebanaStore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/item")
public class OrderItemRestController {
    @Autowired
    OrderItemRepository orderItemRepository;

    OrderItemService orderItemService;

    //CRUD GET
    @RequestMapping("/items")
    public Iterable<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
    //CRUD CREATE
    @PostMapping(path="create", consumes = "application/JSON")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        OrderItem orderItemCreated = orderItemRepository.save(orderItem);
        return orderItemCreated;
    }

    //CRUD UPDATE
    @PutMapping("/update/{id}")
    public OrderItem updateOrderItem (@PathVariable String id, @RequestBody OrderItem orderItem) {
        Optional<OrderItem> orderItemFound = orderItemRepository.findById(id);
        if (orderItemFound.isPresent()) {
            OrderItem orderItemToUpdate = orderItemFound.get();
            OrderItem orderItemUpdated = orderItemRepository.save(orderItemToUpdate);
            return orderItemUpdated;
        } else
            return null;
    }

    //CRUD DELETE
    public String deleteOrderItem(@RequestParam String id){
        Optional<OrderItem> orderItemFound= orderItemRepository.findById(id);
        long countBefore = orderItemRepository.count();
        if(orderItemFound.isPresent()){
            orderItemRepository.deleteById(id);
            long countAfter = orderItemRepository.count();
            String response = "orderItem deleted: " + id +" count: " + countBefore +"/" + countAfter;
            return response;
        } else return "id: " +id +"not found " +"count: " + countBefore;
    }

}

