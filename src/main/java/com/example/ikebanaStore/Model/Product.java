package com.example.ikebanaStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force = true)
public class Product {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        FRESHFLOWER, DRIEDFLOWER, PLANT,
    }
}
