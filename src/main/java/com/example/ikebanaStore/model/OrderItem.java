package com.example.ikebanaStore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    private String id;
    //@NotNull
    private int quantity;
    //@NotNull
    private String price;
    private String createdAt;

    //list of many items of an Order
   @ManyToOne
   @JoinColumn (name= "order_id")
    private Order order;

//    public void addOrder(Order order){
//        this.getOrders().add(order);
//        order.setOrderItem(this);
//    }
    //many products can be in a list of OrderItems

    @ManyToOne
    @JoinColumn (name= "product_id")
    private Product product;


//    public void addProduct (Product product){
//        this.getProducts().add(product);
//    }
}
