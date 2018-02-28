package com.kodilla.good.patterns.challenges.module9challenge2;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        final User user = new User("Jhon");
        final int quantity = 5;
        final Product product = new SimpleProduct("some name");

        return new OrderRequest(user, product, quantity);
    }
}
