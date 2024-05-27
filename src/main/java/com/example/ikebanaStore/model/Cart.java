//package com.example.ikebanaStore.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinTable(name= "cart_product", joinColumns = @JoinColumn(name= "cart_id"),
//    inverseJoinColumns= @JoinColumn(name="product_id"))
//    private List<Product> products=new ArrayList<>();
//
//    public void addProduct(Product product){
//        this.getProducts().add(product);
//    }
//
//    @OneToOne
//    @JoinColumn (name="customer_id")
//    private Customer customer;
//
//}
