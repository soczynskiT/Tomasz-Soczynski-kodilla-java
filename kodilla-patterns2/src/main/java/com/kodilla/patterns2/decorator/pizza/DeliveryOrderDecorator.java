package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DeliveryOrderDecorator extends AbstractPizzaOrderDecorator {
    private final BigDecimal price = new BigDecimal(10);

    protected DeliveryOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaCost() {
        return super.getPizzaCost().add(price);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n + pizza delivery (" + price + " PLN)";
    }
}
