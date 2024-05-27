//package com.example.ikebanaStore.Controller;
//import Service.CartService;
//import com.example.ikebanaStore.Model.Cart;
//import com.example.ikebanaStore.Repository.CartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/cart/")
//public class CartRestController {
//    @Autowired
//    CartService cartService;
//    @Autowired
//    CartRepository cartRepository;
//
//    //CRUD READ
//    public Iterable<Cart> getAllCarts(){
//        return cartRepository.findAll();
//    }
//
//    //CRUD CREATE
//    @PostMapping(path="create", consumes = "application/JSON")
//    public Cart createCart(@RequestBody Cart cart){
//       Cart cartCreated = cartRepository.save(cart);
//        return cartCreated;
//    }
//
//    //CRUD Update
//    @PutMapping("/update/{id}")
//    public Cart updateCart (@PathVariable String id, @RequestBody Cart cart) {
//        Optional<Cart> cartFound = cartRepository.findById(id);
//
//        if (cartFound.isPresent()) {
//            Cart cartToUpdate = cartFound.get();
//            Cart cartUpdated = cartRepository.save(cartToUpdate);
//            return cartUpdated;
//        } else
//            return null;
//    }
//
//    // CRUD DELETE
//    public String deleteCart(@RequestParam String id){
//        Optional<Cart> cartFound= cartRepository.findById(id);
//        long countBefore = cartRepository.count();
//        if(cartFound.isPresent()){
//            cartRepository.deleteById(id);
//            long countAfter = cartRepository.count();
//            String response = "cart deleted: " + id +" count: " + countBefore +"/" + countAfter;
//            return response;
//        } else return "id: " +id +"not found " +"count: " + countBefore;
//    }
//    public String populateCartDB(){
//        cartService.populate();
//        return "ok";
//    }
//
//}
