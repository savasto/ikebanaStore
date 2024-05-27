package com.example.ikebanaStore.service;

import com.example.ikebanaStore.model.Customer;
import com.example.ikebanaStore.model.Order;
import com.example.ikebanaStore.repository.CustomerRepository;
import com.example.ikebanaStore.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;


    public void populate() {
        Faker faker = new Faker(new Locale("en-Gb"));

        Date date = new Date();

        List<Order> orders;

        String uniqueID;
        for (int i=0; i<10; i++){
            uniqueID= UUID.randomUUID().toString();
            Customer customer = new Customer();
            customer.setId(uniqueID);
            customer.setActive(true);
            customer.setName(faker.artist().name());
            customer.setInitDate(date.toString());
            customer.setAge(faker.number().numberBetween(18,100));
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail(faker.internet().emailAddress());
            customer.setLoginStatus(faker.commerce().department());


            orders = orderService.createFakeOrders();

            //add orders to each customer
            for (int j=0; j<10; j++){
                customer.addOrder(orders.get(j));
            }

            customerRepository.save(customer);

        }
    }
}
