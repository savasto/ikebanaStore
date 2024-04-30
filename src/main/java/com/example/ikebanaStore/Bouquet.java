package com.example.ikebanaStore;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Bouquet {

    //we want to ensure that the property isn’t empty or and that the Bouquet name null
    //list of selected products has at least one item.
    //<dependency>
    //<groupId>org.springframework.boot</groupId>
    //<artifactId>spring-boot-starter-validation</artifactId>
    //</dependency>
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size (min=1, message="You must choose at least 1 product")
    private List<Product> products;
}
