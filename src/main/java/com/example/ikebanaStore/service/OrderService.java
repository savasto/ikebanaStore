package com.example.ikebanaStore.service;

//import com.example.ikebanaStore.Model.Bouquet;
import com.example.ikebanaStore.model.Customer;
import com.example.ikebanaStore.model.Order;
//import com.example.ikebanaStore.Repository.BouquetRepository;
//import com.example.ikebanaStore.model.OrderItem;
import com.example.ikebanaStore.repository.CustomerRepository;
//import com.example.ikebanaStore.repository.OrderItemsRepository;
import com.example.ikebanaStore.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    //@Autowired
    //OrderItemsRepository orderItemsRepository;

    public List<Order> createFakeOrders() {
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();

        List<Order> orders = new ArrayList<>();
       // Iterable<Customer> customers = customerRepository.findAll();
      //  Iterable<OrderItem> orderItems = orderItemsRepository.findAll();

        String uniqueID;

        //for (Customer customer : customers) {
          //  for (OrderItem orderItem : orderItems) {

        for (int i=0; i<10; i++){
                uniqueID = UUID.randomUUID().toString();
                Order order = new Order();

                order.setId(uniqueID);
                order.setCreatedAt(date.toString());
                order.setDeliveryName(faker.name().fullName());
                order.setCcNumber(faker.business().creditCardNumber());
                order.setCcExpiration(faker.business().creditCardExpiry());
                order.setCcCVV(faker.number().numberBetween(123, 750));
                order.setDeliveryCity(faker.address().city());
                order.setDeliveryZip(faker.address().zipCode());
                order.setDeliveryStreet(faker.address().streetAddress());
                order.setTotalPrice(faker.commerce().price(20, 200));

                orders.add(order);
            }

        return orders;
    }
        public List<Order> populate () {

        List<Order> orders = createFakeOrders();
        for (int i=0; i<10; i++){
            orderRepository.save(orders.get(i));
            orders.add(orders.get(i));
        }

        return orders;
    }
}