package com.example.ikebanaStore.utils;



import com.example.ikebanaStore.service.CustomerService;
//import com.example.ikebanaStore.service.OrderItemsService;
import com.example.ikebanaStore.service.OrderService;
//import com.example.ikebanaStore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerFillingDB implements ApplicationRunner {

    @Autowired
    OrderService orderService;

  // OrderItemsService orderItemsService;

    //ProductService productService;
    @Autowired
    CustomerService customerService;

//    @Autowired
//    CartService cartService;


    @Override
    public void run(ApplicationArguments args) throws Exception{

        customerService.populate();
        //productService.populate();
        orderService.populate();
       // orderItemsService.populate();
        //cartService.populate();

    }
}
