package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

import java.util.Random;


public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        /* Test of Calculator class */
        Calculator calculator = new Calculator();
        Random random = new Random();

        final int a = random.nextInt();
        final int b = random.nextInt();
        final int addResult = a + b;
        final int subtractResult = b - a;

        if (addResult == calculator.add(a, b)) {
            System.out.println("Add a to b method is working");
        } else {
            System.out.println("Error in method add a t b.");
        }
        if (subtractResult == calculator.subtract(a, b)) {
            System.out.println("Subtract a from b is working.");
        } else {
            System.out.println("Error in method subtract a from b.");
        }
    }
}