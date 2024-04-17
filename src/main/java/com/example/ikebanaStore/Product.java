package com.example.ikebanaStore;

import lombok.Data;

@Data
public class Product {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        FRESHFLOWER, DRIEDFLOWER, PLANT,
    }
}
