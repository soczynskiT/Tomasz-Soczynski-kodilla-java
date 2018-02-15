package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static OptionalDouble getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
    }

    static OptionalDouble getAverage2(int[] numbers) {
        Arrays.stream(numbers)
                .forEach(System.out::println);
        return Arrays.stream(numbers)
                .average();
    }
}
