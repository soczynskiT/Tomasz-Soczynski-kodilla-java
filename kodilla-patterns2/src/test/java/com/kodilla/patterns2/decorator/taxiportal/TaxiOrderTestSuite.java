package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        final TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        final BigDecimal calculatedCost = theOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        final TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        final String description =theOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course", description);
    }
}
