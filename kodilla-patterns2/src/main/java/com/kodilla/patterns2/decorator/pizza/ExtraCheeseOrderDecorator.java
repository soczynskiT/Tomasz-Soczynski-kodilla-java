package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseOrderDecorator extends AbstractPizzaOrderDecorator {
    private final BigDecimal price = new BigDecimal(6);

    protected ExtraCheeseOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaCost() {
        return super.getPizzaCost().add(price);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n + extra cheese (" + price + " PLN)";
    }
}
