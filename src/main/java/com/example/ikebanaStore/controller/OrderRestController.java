package com.example.ikebanaStore.controller;


import com.example.ikebanaStore.service.OrderService;
import com.example.ikebanaStore.model.Order;
import com.example.ikebanaStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/order/")
public class OrderRestController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    //CRUD READ
    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }


    //CRUD CREATE
    @PostMapping (path="create", consumes = "application/JSON")
    public Order createOrder(@RequestBody Order order){
        Order orderCreated = orderRepository.save(order);
        return orderCreated;
    }

    //CRUD Update
    @PutMapping ("/update/{id}")
    public Order updateOrder (@PathVariable String id, @RequestBody Order order) {
        Optional<Order> orderFound = orderRepository.findById(id);

        if (orderFound.isPresent()) {
            Order orderToUpdate = orderFound.get();
            Order orderUpdated = orderRepository.save(orderToUpdate);
            return orderUpdated;
        } else
            return null;
    }

    // CRUD DELETE
    public String deleteOrder(@RequestParam String id){
        Optional<Order> orderFound= orderRepository.findById(id);
        long countBefore = orderRepository.count();
        if(orderFound.isPresent()){
            orderRepository.deleteById(id);
            long countAfter = orderRepository.count();
            String response = "order deleted: " + id +" count: " + countBefore +"/" + countAfter;
            return response;
        } else return "id: " +id +"not found " +"count: " + countBefore;
    }
        public String populateOrderDB(){
            orderService.populate();
            return "ok";
        }
    }

