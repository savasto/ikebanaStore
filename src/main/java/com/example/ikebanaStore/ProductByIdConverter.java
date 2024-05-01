package com.example.ikebanaStore;

import com.example.ikebanaStore.Model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//A converter is any class that implements Spring’s
//Converter convert() interface and implements its method to take one value and convert it to
//another. To convert a String to an Product weĺl use the ProductByIdConverter

//is annotated with to make it IngredientByIdConverter @Component
//discoverable as a bean in the Spring application context. Spring Boot autoconfiguration will
//discover this, and any other beans, and will automatically register them with Spring Converter
//MVC to be used when conversion of request parameters to bound properties is needed.
@Component
public class ProductByIdConverter implements Converter<String, Product> {
    private Map<String, Product> productMap = new HashMap<>();

    public ProductByIdConverter() {
        productMap.put("1",
                new Product("1", "Rose", Product.Type.FRESHFLOWER));
                productMap.put("2",
                        new Product("2", "Tulip", Product.Type.FRESHFLOWER));
                productMap.put("3",
                        new Product("3", "Sunflower", Product.Type.FRESHFLOWER));
                productMap.put("4",
                        new Product("4", "Iris", Product.Type.FRESHFLOWER));
                productMap.put("5",
                        new Product("5", "Weat", Product.Type.DRIEDFLOWER));
                productMap.put("6",
                        new Product("6", "Branch", Product.Type.DRIEDFLOWER));
                productMap.put("7",
                        new Product("7", "Eucalyptus", Product.Type.DRIEDFLOWER));
                productMap.put("8",
                        new Product("8", "Palm", Product.Type.PLANT));
                productMap.put("9",
                        new Product("9", "Olive", Product.Type.PLANT)
                );
    }
    @Override
public Product convert(String id){
        return productMap.get(id);
    }
}
