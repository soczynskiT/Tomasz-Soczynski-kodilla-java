package com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic;

import java.util.HashSet;
import java.util.Set;

public class OrderDatabase {
    private final Set<OrderDTO> refusedOrders = new HashSet<>();
    private final Set<OrderDTO> confirmedOrders = new HashSet<>();

    public void addOrderToDataBase(OrderDTO orderDTO) {
        if (orderDTO.isOrderConfirmed()) {
            confirmedOrders.add(orderDTO);
        } else {
            refusedOrders.add(orderDTO);
        }
    }
}
