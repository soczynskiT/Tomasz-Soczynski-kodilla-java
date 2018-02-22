package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String args[]) {
        final SecondChallenge secondChallenge = new SecondChallenge();

        try {
            final String result = secondChallenge.probablyIWillThrowException(1, 5);
            System.out.println(result);

            final String result2 = secondChallenge.probablyIWillThrowException(10, 4);
            System.out.println(result2);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Task done.");
        }
    }
}
