package com.example.ikebanaStore.utils;

import com.example.ikebanaStore.model.Customer;
import com.example.ikebanaStore.model.Order;
import com.example.ikebanaStore.model.OrderItem;
import com.example.ikebanaStore.model.Product;
import com.example.ikebanaStore.repository.CustomerRepository;
import com.example.ikebanaStore.repository.OrderItemRepository;
import com.example.ikebanaStore.repository.OrderRepository;
import com.example.ikebanaStore.repository.ProductRepository;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;



    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();

        String uniqueID;
        Date date = new Date();

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            uniqueID = UUID.randomUUID().toString();
            Product product = new Product();
            product.setId(uniqueID);
            product.setTitle(faker.food().vegetable());
            product.setInStock(true);
            product.setPrice(faker.number().randomDouble(10, 150, 300));
            product.setDescription(faker.food().fruit());
            product.setSize(faker.number().randomDigitNotZero());
            product.setColor(faker.color().name());
            product.setType(faker.food().ingredient());

            products.add(productRepository.save(product));
        }

        for (int i=0; i<10; i++) {
            uniqueID = UUID.randomUUID().toString();
            Customer customer = new Customer();
            customer.setId(uniqueID);
            customer.setActive(true);
            customer.setName(faker.artist().name());
            customer.setInitDate(date.toString());
            customer.setAge(faker.number().numberBetween(18, 100));
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail(faker.internet().emailAddress());
            customer.setLoginStatus(faker.commerce().department());
            customer = customerRepository.save(customer);

            Order order = new Order();
            order.setCustomer(customer);

            for (int j=0; j<10; j++) {
            uniqueID = UUID.randomUUID().toString();
                    //Order order = new Order();

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

                    order = orderRepository.save(order);


            List<OrderItem> orderItems = new ArrayList<>();
            for (int k = 0; k < 10; k++) {

                uniqueID = UUID.randomUUID().toString();

                OrderItem orderItem = new OrderItem();
                orderItem.setId(uniqueID);
                orderItem.setQuantity(faker.number().randomDigitNotZero());
                orderItem.setPrice(faker.commerce().price());
                orderItem.setCreatedAt(date.toString());
                orderItem.setOrder(order);
                orderItem.setProduct(products.get(faker.random().nextInt(products.size())));
                orderItems.add(orderItemRepository.save(orderItem));
            }
            order.setItems(orderItems);
            orderRepository.save(order);
            }
        }
    }
}

