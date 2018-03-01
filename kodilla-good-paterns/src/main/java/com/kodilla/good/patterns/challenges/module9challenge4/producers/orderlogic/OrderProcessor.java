package com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic;

public class OrderProcessor {
    private OrderRequest orderRequest;

    public OrderProcessor(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    /*Checking order availability by automatic system or request send to producer*/
    private boolean orderAvailabilityConfirmation() {
        System.out.println("Checking an order request for " + orderRequest.getProduct() + " delivered by " + orderRequest.getProducer());
        System.out.println("Order for " + orderRequest.getQuantity() + " items made by " + orderRequest.getShopUser().getFullName());
        System.out.println("Order made at " + orderRequest.getOrderTime());
        return true;
    }

    public OrderDTO process() {
        boolean isOrderConfirmed;

        if (orderAvailabilityConfirmation()) {
            orderRequest.getProducer().process();
            isOrderConfirmed = true;
        } else {
            isOrderConfirmed = false;
        }
        return new OrderDTO(orderRequest, isOrderConfirmed);

    }
}
