//package com.example.ikebanaStore.controller;
//
//import com.example.ikebanaStore.model.Customer;
//import com.example.ikebanaStore.model.OrderItem;
//import com.example.ikebanaStore.repository.OrderItemsRepository;
//import com.example.ikebanaStore.service.OrderItemsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/item")
//public class OrderItemRestController {
//    @Autowired
//    OrderItemsRepository orderItemsRepository;
//
//    OrderItemsService orderItemsService;
//
//    //CRUD GET
//    public Iterable<OrderItem> getAllOrderItems() {
//        return orderItemsRepository.findAll();
//    }
//    //CRUD CREATE
//    @PostMapping(path="create", consumes = "application/JSON")
//    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
//        OrderItem orderItemCreated = orderItemsRepository.save(orderItem);
//        return orderItemCreated;
//    }
//
//    //CRUD UPDATE
//    @PutMapping("/update/{id}")
//    public OrderItem updateOrderItem (@PathVariable String id, @RequestBody OrderItem orderItem) {
//        Optional<OrderItem> orderItemFound = orderItemsRepository.findById(id);
//        if (orderItemFound.isPresent()) {
//            OrderItem orderItemToUpdate = orderItemFound.get();
//            OrderItem orderItemUpdated = orderItemsRepository.save(orderItemToUpdate);
//            return orderItemUpdated;
//        } else
//            return null;
//    }
//
//    //CRUD DELETE
//    public String deleteOrderItem(@RequestParam String id){
//        Optional<OrderItem> orderItemFound= orderItemsRepository.findById(id);
//        long countBefore = orderItemsRepository.count();
//        if(orderItemFound.isPresent()){
//            orderItemsRepository.deleteById(id);
//            long countAfter = orderItemsRepository.count();
//            String response = "orderItem deleted: " + id +" count: " + countBefore +"/" + countAfter;
//            return response;
//        } else return "id: " +id +"not found " +"count: " + countBefore;
//    }
//    public String populateOrderItemDB(){
//        orderItemsService.populate();
//        return "ok";
//    }
//
//}

