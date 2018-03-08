package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.nashorn.internal.objects.Global.Infinity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //When
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = context.getBean(Calculator.class);
        final double a = 10;
        final double b = 5;
        //When
        final double addResult = calculator.add(a, b);
        final double subResult = calculator.sub(a, b);
        final double mulResult = calculator.mul(a, b);
        final double divResult = calculator.div(a, b);
        //Then
        Assert.assertTrue(15 == addResult);
        Assert.assertTrue(5 == subResult);
        Assert.assertTrue(50 == mulResult);
        Assert.assertTrue(2 == divResult);
    }
    @Test
    public void testDivByZeroException() {
        //When
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = (Calculator)context.getBean("calculator");
        final double a = 10;
        final double b = 0;
        //When
        final double divResult = calculator.div(a, b);
        //Then
        Assert.assertTrue(Infinity == divResult);
    }
}
