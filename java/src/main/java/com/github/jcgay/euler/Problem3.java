package com.github.jcgay.euler;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.LongStream.range;
import static java.util.stream.LongStream.rangeClosed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.LongStream;

public class Problem3 {

    private final Long n;

    public Problem3(Long n) {
        this.n = n;
    }

    public static void main(String[] args) {
        System.out.println(new Problem3(600_851_475_143L).largestPrimeFactors());
    }

    public Long largestPrimeFactors() {
        return primesFactor(n, allPrimes(n), 0).stream()
                .max(NaturalOrderComparator.INSTANCE)
                .orElse(0L);
    }

    private List<Long> primesFactor(Long n, LongStream primes, int count) {

        if (isPrime(n)) {
            return asList(n);
        }

        PrimitiveIterator.OfLong remainingPrimes = primes.iterator();
        if (!remainingPrimes.hasNext()){
            return emptyList();
        }

        Long currentPrime = remainingPrimes.next();
        if (n % currentPrime == 0) {
            List<Long> result = new ArrayList<>();
            result.add(currentPrime);
            result.addAll(primesFactor(n / currentPrime, allPrimes(n), 0));
            return result;
        }

        return primesFactor(n, allPrimes(n).skip(++count), count);
    }

    private LongStream allPrimes(Long n) {
        return rangeClosed(2, (long) Math.sqrt(n.doubleValue()))
                .filter(x -> isPrime(x));
    }

    public boolean isPrime(Long n) {
        if (n <= 1) {
            return false;
        }

        return range(2, (long) Math.sqrt(n.doubleValue()))
                .allMatch(x -> n % x != 0);
    }

    private static enum NaturalOrderComparator implements Comparator<Long> {
        INSTANCE;

        @Override
        public int compare(Long c1, Long c2) {
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Long> reversed() {
            return Comparator.reverseOrder();
        }
    }
}
