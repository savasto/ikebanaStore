package com.example.ikebanaStore;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class BouquetOrder {
    @NotBlank (message="Delivery Name is required")
    private String deliveryName;
    @NotBlank (message="Street is required")
    private String deliveryStreet;
    @NotBlank (message="City is required")
    private String deliveryCity;
    @NotBlank (message="Zip is required")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    //private String orderDate;

    private List<Bouquet> bouquets = new ArrayList<>();

    public void addBouquet(Bouquet bouquet) {

        this.bouquets.add(bouquet);
    }
}

