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
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Product {
//    @Id
//    private  String id;
//    private  String title;
//   // private String imageURL;
//   // private Binary photoOfProduct;
//    private  Boolean inStock;
//    private  Double price;
//    private  String description;
//    private  int size;
//    private String color;
//    private String type;
//
////    @ManyToMany(mappedBy = "products", fetch =FetchType.LAZY)
////    private List<Cart> carts = new ArrayList<>();
////
////    public void addCart(Cart cart){
////        this.getCarts().add(cart);
////    }
//
//    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    public void addOrderItem (OrderItem orderItem){
//        this.getOrderItems().add(orderItem);
//    }
//
////    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
////    private List<Bouquet> bouquets;
//}
