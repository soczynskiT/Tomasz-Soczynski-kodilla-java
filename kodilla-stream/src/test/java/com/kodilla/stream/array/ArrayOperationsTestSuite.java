package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void tesGetAverage() {
        //Given
        final int[] intArray = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        double result = ArrayOperations.getAverage(intArray).orElse(0);
        //Then
        Assert.assertTrue(7.50 == result);
    }

    @Test
    public void tesGetAverage2() {
        //Given
        final int[] intArray = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //When
        double result = ArrayOperations.getAverage2(intArray).orElse(0);
        //Then
        Assert.assertTrue(7.50 == result);
    }
}
