package com.kodilla.good.patterns.challenges.module9challenge2;

public class SimpleProduct implements Product {
    final private String name;

    public SimpleProduct(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
