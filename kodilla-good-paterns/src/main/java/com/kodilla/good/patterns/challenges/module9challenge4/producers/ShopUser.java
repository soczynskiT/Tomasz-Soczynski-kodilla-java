package com.kodilla.good.patterns.challenges.module9challenge4.producers;

public class ShopUser {
    private String fullName;
    private String address;
    private int age;

    public ShopUser(String fullName, String address, int age) {
        this.fullName = fullName;
        this.address = address;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }
}
