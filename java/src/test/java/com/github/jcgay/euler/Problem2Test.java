package com.github.jcgay.euler;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {

    private final Problem2 underTest = new Problem2();

    @Test
    public void should_sum_even_numbers_from_fibonacci_sequence() throws Exception {
        assertThat(underTest.sumEvenFibonacciNumbers(100L)).isEqualTo(44);
        assertThat(underTest.sumEvenFibonacciNumbers(4_000_000L)).isEqualTo(4613732);
    }
}
