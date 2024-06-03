package com.example.ikebanaStore.service;

import com.example.ikebanaStore.model.Product;
import com.example.ikebanaStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts(){
    return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}

