//package com.example.ikebanaStore.service;
//
//import com.example.ikebanaStore.model.Product;
//import com.example.ikebanaStore.repository.ProductRepository;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class ProductService {
//    @Autowired
//    ProductRepository productRepository;
//
//    public List<Product> createFakeProducts(){
//
//        Faker faker= new Faker(new Locale("en-GB"));
//        Date date = new Date();
//        List<Product> products =new ArrayList<>();
//
//        String uniqueID;
//
//        for (int i=0; i<10; i++){
//            uniqueID= UUID.randomUUID().toString();
//            Product product = new Product();
//            product.setId(uniqueID);
//            product.setTitle(faker.food().vegetable());
//            product.setInStock(true);
//            product.setPrice(faker.number().randomDouble(10,150,300));
//            product.setDescription(faker.dune().quote());
//            product.setSize(faker.number().randomDigitNotZero());
//            product.setColor(faker.color().name());
//            product.setType(faker.food().ingredient());
//
//            products.add(product);
//        }
//        return products;
//    }
//    public List<Product> populate(){
//        List<Product> products =createFakeProducts();
//        for (int i=0; i<10; i++){
//            productRepository.save(products.get(i));
//            products.add(products.get(i));
//        }
//        return products;
//    }
//
//}
