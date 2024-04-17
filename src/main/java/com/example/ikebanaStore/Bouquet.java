package com.example.ikebanaStore;

import lombok.Data;

import java.util.List;

@Data
public class Bouquet {
    private String name;
    private List<Product> products;
}
