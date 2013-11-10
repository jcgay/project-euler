package com.github.jcgay.euler;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {

    private final Problem1 underTest = new Problem1();

    @Test
    public void should_sum_all_multiples_of_3_or_5() throws Exception {
        assertThat(underTest.sumMultiplesOf3or5(10)).isEqualTo(23);
        assertThat(underTest.sumMultiplesOf3or5(1000)).isEqualTo(233168);
    }
}
