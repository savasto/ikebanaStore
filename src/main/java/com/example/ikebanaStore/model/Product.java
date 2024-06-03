package com.example.ikebanaStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private  String id;
    private  String title;
   // private String imageURL;
   // private Binary photoOfProduct;
    private  Boolean inStock;
    private  Double price;
    private  String description;
    private  int size;
    private String color;
    private String type;

//    //many Products can be in one Cart
//    @JsonIgnore
//    @ManyToOne( fetch =FetchType.LAZY)
//    @JoinColumn(name = "cart")
//    private Cart cart;


    //many products can be in a list of OrderItems
//    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    public void addOrderItem (OrderItem orderItem){
//
//        this.getOrderItems().add(orderItem);
//
//    }

}
