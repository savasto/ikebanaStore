package com.example.ikebanaStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"ORDER\"") //The word "order" is a reserved keyword in SQL, and using it as a table name requires special handling.
// Specifically, you need to enclose the table name in quotes or backticks, depending on the database you're using.
public class Order {

    @Id
    private String id;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_FK")
    private Customer customer;

    private String createdAt;

    //@NotBlank (message="Delivery Name is required")
    private String deliveryName;
    //@NotBlank (message="Street is required")
    private String deliveryStreet;
    //@NotBlank (message="City is required")
    private String deliveryCity;
    //@NotBlank (message="Zip is required")
    private String deliveryZip;

    private String totalPrice;
    //@CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    //@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            //message="Must be formatted MM/YY")
    private String ccExpiration;
    //@Digits(integer=3, fraction=0, message="Invalid CVV")
    private int ccCVV;

//    @OneToMany (mappedBy = "order", cascade =CascadeType.ALL)
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    public void addOrderItem (OrderItem orderItem){
//        this.getOrderItems().add(orderItem);
//        orderItem.setOrder(this);
//    }




}

