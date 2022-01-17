package com.csmarton.hackerrank.algorithms.basic;

import java.util.*;
import java.util.stream.Collectors;

public class CountTriplets {

    public long solution2(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;


        if(ratio == 1) {
            Map<Long, Integer> numOfChildren = new HashMap<>();
            for (int i = 0; i < numbers.size(); i++) {
                Long baseNumber = ((Number) numbers.get(i)).longValue();
                if (numOfChildren.containsKey(baseNumber)) {
                    numOfChildren.put(baseNumber, numOfChildren.get(baseNumber) + 1);
                } else
                    numOfChildren.put(baseNumber, 1);
            }
            for (Map.Entry<Long, Integer> entry : numOfChildren.entrySet()) {
                int size = entry.getValue();
                if (size < 3)
                    continue;
                if(size < 4) {
                    numOfTriplets++;
                    continue;
                }
                long mainIncr = 4;
                long middleIncr = 3;

                int base = 2;
                for (int i = 0; i < size - 4; i++) {
                    base++;
                    middleIncr += base;
                    mainIncr = mainIncr + middleIncr;
                }
                numOfTriplets += mainIncr;
            }

            return numOfTriplets;
        }

        Map<Long, List<Integer>> numOfOccurences = new HashMap<>();
        Map<Integer, Integer> numOfChild = new HashMap<>();
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
            numOfChild.put(i, ratioedIndexes.size());
        }

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> secondNode = numMap.get(i);

            long count = secondNode.stream().parallel().map(key -> numOfChild.get(key)).mapToInt(Integer::valueOf).sum();

            numOfTriplets += count;
        }

        return numOfTriplets;
    }
}
