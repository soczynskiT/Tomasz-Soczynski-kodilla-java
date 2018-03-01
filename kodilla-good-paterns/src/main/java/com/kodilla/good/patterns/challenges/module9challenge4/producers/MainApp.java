package com.kodilla.good.patterns.challenges.module9challenge4.producers;

import com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic.*;

public class MainApp {
    public static void main(String args[]) {
        final OrderDatabase orderDatabase = new OrderDatabase();

        final OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        final OrderRequest newOrderRequest = orderRequestRetriever.retrieveRequest();

        final OrderProcessor orderProcessor = new OrderProcessor(newOrderRequest);

        final OrderDTO orderDTO = orderProcessor.process();
        orderDatabase.addOrderToDataBase(orderDTO);
    }
}
