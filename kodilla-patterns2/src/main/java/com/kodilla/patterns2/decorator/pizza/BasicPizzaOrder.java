package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getPizzaCost() {
        return new BigDecimal(20);
    }

    @Override
    public String getDescription() {
        return "Basic pizza with cheese and tomato sauce (" + getPizzaCost() + " PLN)";
    }
}
