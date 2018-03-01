package com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic;


public class OrderDTO {
    final private OrderRequest orderRequest;
    final private boolean isOrderConfirmed;

    public OrderDTO(OrderRequest orderRequest, boolean isOrderConfirmed) {
        this.orderRequest = orderRequest;
        this.isOrderConfirmed = isOrderConfirmed;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrderConfirmed() {
        return isOrderConfirmed;
    }
}
