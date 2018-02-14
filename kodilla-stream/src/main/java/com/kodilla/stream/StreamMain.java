package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        final Processor processor = new Processor();
        processor.execute(() -> System.out.println("Some text"));

        final ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nTask for Module 7.1:");
        final PoemBeautifier poemBeautifier = new PoemBeautifier();
        final String first = poemBeautifier.beautify("First, sample text", (string) -> "ABC " + string + " ABC");
        final String second = poemBeautifier.beautify("Second, sample text", String::toUpperCase);
        final String third = poemBeautifier.beautify("Third, sample text", (string) -> string.replace(" ", "_"));
        final String fourth = poemBeautifier.beautify("Fourth, sample text", (string -> string.replace("", "\n")));
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}