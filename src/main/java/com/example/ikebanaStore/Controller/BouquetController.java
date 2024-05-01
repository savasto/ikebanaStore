package com.example.ikebanaStore.Controller;

import com.example.ikebanaStore.Model.Bouquet;
import com.example.ikebanaStore.Model.Product;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("bouquetOrder")
public class BouquetController {
    @ModelAttribute
    public void addProductsToModel(Model model) {
        List<Product> products = Arrays.asList(
                new Product("1", "Rose", Product.Type.FRESHFLOWER),
                new Product("2", "Tulip", Product.Type.FRESHFLOWER),
                new Product("3", "Sunflower", Product.Type.FRESHFLOWER),
                new Product("4", "Iris", Product.Type.FRESHFLOWER),
                new Product("5", "Weat", Product.Type.DRIEDFLOWER),
                new Product("6", "Branch", Product.Type.DRIEDFLOWER),
                new Product("7", "Eucalyptus", Product.Type.DRIEDFLOWER),
                new Product("8", "Palm", Product.Type.PLANT),
                new Product("9", "Olive", Product.Type.PLANT)

        );

        Product.Type[] types = Product.Type.values();
        for (Product.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(products, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("bouquet", new Bouquet());
        return "design";
    }

    private Iterable<Product> filterByType(
            List<Product> products, Product.Type type) {
        return products
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }
    @PostMapping
    public String processBouquet(@Valid @ModelAttribute("bouquet") Bouquet bouquet, Errors errors){
        if (errors.hasErrors()){
            return "design";
        }
        //save the bouquet
        log.info("Processing bouquet:" + bouquet);

        return "redirect:/orders/current";
    }
}
