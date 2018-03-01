package com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic;

import com.kodilla.good.patterns.challenges.module9challenge4.producers.ShopUser;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.producers.Producer;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Product;


import java.time.LocalDate;

public class OrderRequest {
    private ShopUser shopUser;
    private Producer producer;
    private Product product;
    private int quantity;
    private LocalDate orderTime;

    public OrderRequest(ShopUser shopUser, Producer producer, Product product, int quantity, LocalDate orderTime) {
        this.shopUser = shopUser;
        this.producer = producer;
        this.product = product;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }
}
