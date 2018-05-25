package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MuschroomsOrderDecorator extends AbstractPizzaOrderDecorator {
    private final BigDecimal price = new BigDecimal(6);

    protected MuschroomsOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaCost() {
        return super.getPizzaCost().add(price);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n + mushrooms (" + price + " PLN)";
    }
}
