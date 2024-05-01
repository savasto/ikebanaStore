package com.example.ikebanaStore.Controller;


import com.example.ikebanaStore.Model.BouquetOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//The idea is that after creating a bouquet, the user will be redirected to an order form from which they
//can place an order to have their bouquet creations delivered. For this we have a controller that
//will handle a request for /orders/current.


@Slf4j //annotation to create a free SLF4J object at @Slf4j Logger object at compile-time.
// You’ll use this in a moment to log the details of the order that’s submitted.
@Controller
@RequestMapping("/orders") //specifies that any request-handling methods in this controller
// will handle requests whose path begins with /orders.
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("bouquetOrder", new BouquetOrder());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid BouquetOrder bouquetOrder, Errors errors){
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: "+ bouquetOrder);
        return "redirect:/";
    }
}
