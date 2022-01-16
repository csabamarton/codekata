package com.csmarton.hackerrank.algorithms.basic;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
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


    public long solution2(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;

        Map<Long, List<Integer>> numOfOccurences = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();
            if(numOfOccurences.containsKey(baseNumber)) {
                numOfOccurences.get(baseNumber).add(i);
            } else
                numOfOccurences.put(baseNumber, new ArrayList<>(Arrays.asList(i)));
        }

        Map<Integer, List<Integer>> numMap= new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();

            final int index = i;

            List<Integer> ratioedIndexes = new ArrayList<>();
            if (numOfOccurences.containsKey(baseNumber * ratio))
            {
                ratioedIndexes = numOfOccurences.get(baseNumber * ratio);
                ratioedIndexes = ratioedIndexes.stream().filter(num -> num > index).collect(Collectors.toList());
            }

            numMap.put(i, ratioedIndexes);
        }

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> secondNode = numMap.get(i);
            long count = secondNode.stream().parallel().map(key -> numMap.get(key).size()).mapToInt(Integer::valueOf).sum();
            numOfTriplets += count;
        }

        return numOfTriplets;
    }

    private void checkLeaf(Integer index, List<Integer> routeLengths, Map<Integer, List<Integer>> numMap, int depth) {
        List<Integer> leafIndexes = numMap.get(index);
        if (leafIndexes.isEmpty()) {
            routeLengths.add(depth);
            return;
        }
        for (Integer leafIndex: leafIndexes) {
            checkLeaf(leafIndex, routeLengths, numMap, depth + 1);
        }
    }
}
