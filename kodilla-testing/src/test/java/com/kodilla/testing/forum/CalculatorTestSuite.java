package com.kodilla.testing.forum;

import com.kodilla.testing.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CalculatorTestSuite {
    private Random random = new Random();

    @Test
    public void testCalcAddMethod() {
        //Given
        Calculator calculator = new Calculator();
        final int a = random.nextInt();
        final int b = random.nextInt();
        //When
        final int addResult = a + b;
        //Then
        Assert.assertEquals(addResult, calculator.add(a, b));
    }

    @Test
    public void testCalcSubtractMethod() {
        //Given
        Calculator calculator = new Calculator();
        final int a = random.nextInt();
        final int b = random.nextInt();
        //When
        final int subtractResult = b - a;
        //Then
        Assert.assertEquals(subtractResult, calculator.subtract(a, b));
    }
}
