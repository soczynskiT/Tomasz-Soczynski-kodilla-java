package com.kodilla.good.patterns.challenges.module9challenge4.producers.producers;


import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Product;

import java.util.HashSet;


public class ExtraFoodShop implements Producer {
    private String name = "ExtraFoodShop";
    private HashSet<Product> productsOffer = new HashSet<>();

    @Override
    public void process() {
        System.out.println("Order confirmed, processing - method 2");
    }


    @Override
    public Product getProduct() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
