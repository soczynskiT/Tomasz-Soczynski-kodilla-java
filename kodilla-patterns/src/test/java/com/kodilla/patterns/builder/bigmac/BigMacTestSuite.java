package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.components.Ingredients;
import com.kodilla.patterns.builder.bigmac.components.Sauce;
import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {
    @Test
    public void testCreateNewBigMacWithAvailableComponents() {
        //Given
        final BigMac customBigMac = new BigMac.BigMacBuilder()
                .roll(true)
                .burgers(2)
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.LETTUCE)
                .ingredients(Ingredients.CUCUMBER)
                .ingredients(Ingredients.ONION)
                .sauce(Sauce.THOUSAND_ISLANDS)
                .build();
        System.out.println(customBigMac);
        //When
        final String chosenRollType = "roll with sesame";
        final int takenBurgersNo = 2;
        final String chosenSauce = Sauce.THOUSAND_ISLANDS;
        final int noOfTakenIngredients = 4;

        //Then
        Assert.assertEquals(chosenRollType, customBigMac.getRoll().toString());
        Assert.assertEquals(takenBurgersNo, customBigMac.getBurgers());
        Assert.assertEquals(chosenSauce, customBigMac.getSauceName());
        Assert.assertEquals(noOfTakenIngredients, customBigMac.getBurgerIngredients().size());
    }

    @Test
    public void testCreateBigMacWithoutRoll() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .burgers(2)
                .sauce(Sauce.STANDARD)
                .build();
        //When
        BigMac resultBigMac = null;

        //Then
        Assert.assertEquals(resultBigMac, bigMac);
    }

    @Test
    public void testCreateBigMacWithUnavailableComponents() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .roll(true)
                .burgers(0)
                .sauce("Mayonesse")
                .ingredients(Ingredients.TOMATO)
                .build();

        System.out.println(bigMac);
        //When
        final String expectedSauce = "Mayonesse";
        final String expectedIngredient = Ingredients.TOMATO;

        //Then
        Assert.assertTrue(bigMac.getRoll().isWithSesame());
        Assert.assertFalse(expectedSauce.equals(bigMac.getSauceName()));
        Assert.assertFalse(bigMac.getBurgerIngredients().contains(expectedIngredient));
    }
}
