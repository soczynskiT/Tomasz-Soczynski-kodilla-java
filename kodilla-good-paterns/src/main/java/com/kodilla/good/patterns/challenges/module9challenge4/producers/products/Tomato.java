package com.kodilla.good.patterns.challenges.module9challenge4.producers.products;

public class Tomato implements Product {
    private String name = "Tomato";

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
