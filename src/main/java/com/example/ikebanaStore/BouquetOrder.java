package com.example.ikebanaStore;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BouquetOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Bouquet> bouquets = new ArrayList<>();

    public void addBouquet(Bouquet bouquet) {
        this.bouquets.add(bouquet);
    }
}

