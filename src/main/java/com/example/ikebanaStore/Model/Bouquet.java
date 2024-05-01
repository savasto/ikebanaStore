package com.example.ikebanaStore.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Bouquet {
    //we want to ensure that the property isn’t empty or and that the Bouquet name null
    //list of selected products has at least one item.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Because you’re relying on the database to automatically generate the ID @Id
    //value, you also annotate the property with , specifying a of id @GeneratedValue strategy
    //AUTO.
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private Date createdAt= new Date();

    @NotNull
    @Size (min=1, message="You must choose at least 1 product")
    @ManyToMany()
    private List<Product> products= new ArrayList<>();

    public void addProduct (Product product){
        this.products.add(product);
    }
}

