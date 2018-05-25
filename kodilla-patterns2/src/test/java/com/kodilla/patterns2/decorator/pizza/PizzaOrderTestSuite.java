package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testForPizzaOrderGetCostWithAllAddOns() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new MuschroomsOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraSauceOrderDecorator(pizzaOrder);
        pizzaOrder = new DeliveryOrderDecorator(pizzaOrder);

        //When
        BigDecimal totalCost = pizzaOrder.getPizzaCost();

        //Then
        Assert.assertEquals(new BigDecimal(49), totalCost);
    }

    @Test
    public void testForPizzaOrderGetDescriptionWithAllAddOns() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new MuschroomsOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraSauceOrderDecorator(pizzaOrder);
        pizzaOrder = new DeliveryOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();
        System.out.println(description);

        //Then
        Assert.assertEquals("Basic pizza with cheese and tomato sauce (20 PLN)\n" +
                " + extra cheese (6 PLN)\n" +
                " + mushrooms (6 PLN)\n" +
                " + extra sauce (7 PLN)\n" +
                " + pizza delivery (10 PLN)", description);
    }
}
