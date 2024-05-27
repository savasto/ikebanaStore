//package com.example.ikebanaStore.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class Bouquet {
//    //we want to ensure that the property isn’t empty or and that the Bouquet name null
//    //list of selected products has at least one item.
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) //Because you’re relying on the database to automatically generate the ID @Id
//    //value, you also annotate the property with , specifying a of id @GeneratedValue strategy
//    //AUTO.
//    private String id;
//
//    @NotNull
//    @Size(min=5, message="Name must be at least 5 characters long")
//    private String name;
//
//    private Date createdAt= new Date();
//
//    //@NotNull
//    //@Size(min =1, message="You must choose at least 1 product")
//   // private String quantityProducts;
//
//    @NotNull
//    @Size (min=1, message="You must choose at least 1 product")
//    @JsonIgnore
//    @ManyToMany(cascade= CascadeType.ALL)
//    @JoinTable(name= "BOUQUET_PRODUCT_FKS",
//    joinColumns=@JoinColumn(name="BOUQUET_FK"),
//    inverseJoinColumns=@JoinColumn(name= "PRODUCT_FK"))
//    private List<Product> products= new ArrayList<>();
//
//    @OneToMany(mappedBy = "bouquet", cascade= CascadeType.ALL)
//    private List<ImageOfBouquet> imageOfBouquets = new ArrayList<>();
//
//    public void addProduct (Product product){
//        this.getProducts().add(product);
//        product.setBouquet(this);
//    }
//    public void addImageOfBouquet(ImageOfBouquet imageOfBouquet){
//        this.getImageOfBouquets().add(imageOfBouquet);
//    }
//}

