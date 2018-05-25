package com.kodilla.exception.test;

public class FirstChallenge {

    private double divide(double a, double b) {
        final double result;
        String divideInfo = "";
        try {
            // Divide by double = 0.0 get result infinity without throwing an Exception
            // Exception thrown manually.

            if (b != 0) {
                result = a / b;
                divideInfo = "Correct";
                return result;
            } else {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException aex) {
            divideInfo = "Error: " + aex.toString();
            return 0;
        } finally {
            System.out.println(divideInfo);
        }

    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        final double result = firstChallenge.divide(3, 0);
        System.out.println(result);

        System.out.println("\n");

        final double result2 = firstChallenge.divide(10, 5);
        System.out.println(result2);
    }
}