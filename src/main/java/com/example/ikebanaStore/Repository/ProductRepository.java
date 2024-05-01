package com.example.ikebanaStore.Repository;

import com.example.ikebanaStore.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
