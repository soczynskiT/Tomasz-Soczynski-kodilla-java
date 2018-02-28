package com.kodilla.good.patterns.challenges.module9challenge2;

public class Main {
    public static void main(String args[]) {

        final OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        final OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailConfirmation(), new SimpleProductOrderService(), new SimpleProductOrderRepository());
        orderProcessor.process(orderRequest);
    }
}