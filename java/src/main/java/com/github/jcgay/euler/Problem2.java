package com.github.jcgay.euler;

import java.util.stream.LongStream;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(new Problem2().sumEvenFibonacciNumbers(4_000_000L));
    }

    public Long sumEvenFibonacciNumbers(Long limit) {
        return fibonacciUntil(limit)
                .filter(x -> x % 2 == 0)
                .sum();
    }

    private LongStream fibonacciUntil(Long limit) {
        LongStream.Builder result = LongStream.builder();
        long i = 1L;
        while(true) {
            Long fibonacci = fibonacci(i);
            if (fibonacci > limit) {
                break;
            }
            result.accept(fibonacci);
            i++;
        }
        return result.build();
    }

    private Long fibonacci(Long n) {
        if (n <= 1) {
            return n;
        } else {
            return (fibonacci(n - 2) + fibonacci(n - 1));
        }
    }
}
