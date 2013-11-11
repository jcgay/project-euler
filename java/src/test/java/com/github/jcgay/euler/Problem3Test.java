package com.github.jcgay.euler;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3Test {

    @Test
    public void should_get_the_largest_prime_factors() throws Exception {
        assertThat(new Problem3(13195L).largestPrimeFactors()).isEqualTo(29);
        assertThat(new Problem3(600_851_475_143L).largestPrimeFactors()).isEqualTo(6857);
    }
}
