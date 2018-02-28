package com.kodilla.good.patterns.challenges.module9challenge2;


public class SimpleProductOrderService implements OrderService {
    public boolean order (OrderRequest orderRequest) {
        System.out.println(orderRequest.getUser().getName() + "ordering " + orderRequest.getQuantity() + " items of " + orderRequest.getProduct().getName());
        return true;
    }
}