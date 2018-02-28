package com.kodilla.good.patterns.challenges.module9challenge2;


public class OrderProcessor {
    final private InformationService informationService;
    final private OrderService orderService;
    final private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest);
        if (isOrdered) {
            informationService.confirmOrder();
            orderRepository.addTroRepo();
            return new OrderDTO(orderRequest.getUser().getName(), orderRequest, true);
        } else {
            return new OrderDTO(orderRequest.getUser().getName(), orderRequest, false);
        }
    }
}
