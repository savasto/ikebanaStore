//package com.example.ikebanaStore.service;
//
////import com.example.ikebanaStore.Model.Cart;
//import com.example.ikebanaStore.model.OrderItem;
//import com.example.ikebanaStore.model.Product;
//import com.example.ikebanaStore.repository.OrderItemsRepository;
//import com.example.ikebanaStore.repository.ProductRepository;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class OrderItemsService {
//    @Autowired
//    OrderItemsRepository orderItemsRepository;
//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    ProductService productService;
//    @Autowired
//
//
//
//    public List<OrderItem> createFakeOrderItems() {
//        Faker faker = new Faker(new Locale("en-Gb"));
//        Date date = new Date();
//
//        List<OrderItem> orderItems = new ArrayList<>();
//        String uniqueID;
//
//        for (int i = 0; i < 10; i++) {
//            uniqueID = UUID.randomUUID().toString();
//
//            OrderItem orderItem = new OrderItem();
//
//            orderItem.setId(uniqueID);
//            orderItem.setQuantity(faker.number().randomDigitNotZero());
//            orderItem.setPrice(faker.commerce().price());
//            orderItem.setCreatedAt(faker.date().toString());
//
//            orderItems.add(orderItem);
//        }
//        return orderItems;
//    }
//
//    public List<OrderItem> populate(){
//        List<OrderItem> orderItems = createFakeOrderItems();
//        List<Product> products =productService.createFakeProducts();
//
//        for (OrderItem orIt : orderItems){
//
//            orderItemsRepository.save(orIt);
//            for (Product prod : products){
//                productRepository.save(prod);
//                orIt.addProduct(prod);
//                orderItemsRepository.save(orIt);
//            }
//        }
//        return orderItems;
//
//    }
//
//




