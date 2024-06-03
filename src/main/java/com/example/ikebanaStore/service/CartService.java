
//package com.example.ikebanaStore.service;
//
//
//import com.example.ikebanaStore.model.Cart;
//import com.example.ikebanaStore.model.Product;
//import com.example.ikebanaStore.repository.CartRepository;
//import com.example.ikebanaStore.repository.ProductRepository;
//import com.example.ikebanaStore.service.ProductService;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Locale;
//import java.util.UUID;
//
//@Service
//public class CartService {
//    @Autowired
//    private CartRepository cartRepository;
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private ProductRepository productRepository;
//
//
//
//    public void populate(){
//        Faker faker =new Faker(new Locale("en-Gb"));
//        List<Product> products;
//        String uniqueID;
//        for(int i=0; i<10; i++){
//            uniqueID= UUID.randomUUID().toString();
//            Cart cart= new Cart();
//            cart.setId(uniqueID);
//            cart.setCreatedAt(faker.date().toString());
//            cart.setStatus(true);
//            cart.setTotalCartPrice(faker.commerce().price(1,10));
//            cart.setPaymentMethod(faker.currency().name());
//            cart.setDeliveryMethod(faker.aviation().aircraft());
//
//            products = productService.createFakeProducts();
//
//            for (int j=0; j<10; j++){
//                cart.addProduct(products.get(j));
//
//            }
//            cartRepository.save(cart);
//        }
//
//    }
//}
