package com.kodilla.good.patterns.challenges.module9challenge4.producers.producers;

import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Product;

import java.util.HashSet;

public class HealthyShop implements Producer {
    private String name = "HealthyShop";
    private HashSet<Product> productsOffer = new HashSet<>();

    @Override
    public void process() {
        System.out.println("Request of order confirmed - processing - method 1");
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
