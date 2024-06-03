//package com.example.ikebanaStore.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Cart {
//    @Id
//    private String id;
//    private String createdAt;
//    private Boolean status;
//    private String totalCartPrice;
//    private String paymentMethod;
//    private String deliveryMethod;
//
//    //many products can be in a list of OrderItems
//    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinTable(name= "cart_product", joinColumns = @JoinColumn(name= "cart_id"),
//    inverseJoinColumns= @JoinColumn(name="product_id"))
//    private List<Product> products=new ArrayList<>();
//
//    public void addProduct(Product product){
//        this.getProducts().add(product);
//    }
//
//    //each customer has only one cart to make Order later
//    @OneToOne
//    @JoinColumn (name="customer_id")
//    private Customer customer;
//
//
//}
