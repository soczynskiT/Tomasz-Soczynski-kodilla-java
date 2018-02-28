package com.kodilla.good.patterns.challenges.module9challenge2;

public class OrderDTO {
    final private String userName;
    final private OrderRequest request;
    final private boolean isOrderConfirmed;

    public OrderDTO(String userName, OrderRequest request, boolean isOrderConfirmed) {
        this.userName = userName;
        this.request = request;
        this.isOrderConfirmed = isOrderConfirmed;
    }
}

