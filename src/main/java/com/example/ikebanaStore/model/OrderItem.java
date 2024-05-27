//package com.example.ikebanaStore.model;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrderItem {
//    @Id
//    private String id;
//    //@NotNull
//    private int quantity;
//    //@NotNull
//    private String price;
//    private String createdAt;
//
//    @JsonIgnore
//    @JoinColumn(name="ORDER_FK")
//    @ManyToOne (fetch = FetchType.LAZY)
//    private Order order;
//
//
//    @JsonIgnore
//    @ManyToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinTable (name= "OrderItem_Product_FKS",
//          joinColumns = @JoinColumn(name= "ORDER_ITEM_FK"),
//          inverseJoinColumns= @JoinColumn(name= "PRODUCT_FK"))
//    private List<Product> products=new ArrayList<>();
//
//
//    public void addProduct (Product product){
//        this.getProducts().add(product);
//    }
//}
