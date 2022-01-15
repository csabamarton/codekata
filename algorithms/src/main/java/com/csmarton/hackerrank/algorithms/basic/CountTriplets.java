package com.csmarton.hackerrank.algorithms.basic;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class CountTriplets {

    public long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public long solution(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;

        Map<Long, Integer> numOfOccurences = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long key = ((Number) numbers.get(i)).longValue();
            if(numOfOccurences.containsKey(key)) {
                numOfOccurences.put(key, numOfOccurences.get(key) + 1);
            } else
                numOfOccurences.put(key, 1);
        }

        for(Map.Entry<Long, Integer> entry : numOfOccurences.entrySet()) {
            Long baseNumber = entry.getKey();

            if(ratio == 1) {
                numOfTriplets += factorialUsingForLoop(entry.getValue()-1);
                numOfTriplets += LongStream.rangeClosed(1, entry.getValue()-1)
                        .reduce(1, (long x, long y) -> x * y);
                continue;
            }

            int first = numOfOccurences.get(baseNumber);
            int second = numOfOccurences.containsKey(baseNumber * ratio) ?
                    numOfOccurences.get(baseNumber * ratio) : 0;
            int third = numOfOccurences.containsKey(baseNumber * ratio * ratio) ?
                    numOfOccurences.get(baseNumber * ratio * ratio) : 0;

            numOfTriplets += first * second * third;
        }

        return numOfTriplets;
    }
}
