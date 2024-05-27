package com.example.ikebanaStore.model;

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
public class Customer {
    @Id
    private String id;
    private String name;
    private String loginStatus;
    private int age;
    private Boolean active;
    private String address;
    private String email;
    private String password;
    private String initDate;

    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders= new ArrayList<>();

    public void addOrder (Order order){
        this.getOrders().add(order);
        order.setCustomer(this);
    }
//    @OneToOne(mappedBy= "customer", cascade = CascadeType.ALL)
//    private Cart cart;
//
//    public void addCart(Cart cart){
//        this.cart=cart;
//        if (cart!=null){
//            cart.setCustomer(this);
//        }
//    }

}
