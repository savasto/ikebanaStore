package com.example.ikebanaStore.controller;

import com.example.ikebanaStore.service.ProductService;
import com.example.ikebanaStore.model.Product;
import com.example.ikebanaStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/product/")
public class ProductRestController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    //CRUD READ
    @RequestMapping("/products")
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //CRUD CREATE
    @PostMapping(path="create", consumes = "application/JSON")
    public Product createProduct(@RequestBody Product product){
        Product productCreated = productRepository.save(product);
        return productCreated;
    }

    //CRUD Update
    @PutMapping ("/update/{id}")
    public Product updateProduct (@PathVariable String id, @RequestBody Product product) {
        Optional<Product> productFound = productRepository.findById(id);

        if (productFound.isPresent()) {
            Product productToUpdate = productFound.get();
            Product productUpdated = productRepository.save(productToUpdate);
            return productUpdated;
        } else
            return null;
    }

    // CRUD DELETE
    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam String id){
        Optional<Product> productFound= productRepository.findById(id);
        long countBefore = productRepository.count();
        if(productFound.isPresent()){
            productRepository.deleteById(id);
            long countAfter = productRepository.count();
            String response = "product deleted: " + id +" count: " + countBefore +"/" + countAfter;
            return response;
        } else return "id: " +id +"not found " +"count: " + countBefore;
    }

}


