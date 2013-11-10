package com.github.jcgay.euler;

import static java.util.stream.IntStream.range;

public class Problem1 {

    public int sumMultiplesOf3or5(int limit) {
        return range(0, limit)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .sum();
    }
}
