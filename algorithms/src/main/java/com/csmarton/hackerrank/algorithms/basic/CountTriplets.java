package com.csmarton.hackerrank.algorithms.basic;

import java.util.*;

public class CountTriplets {

    public long solution(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;

        Map<Long, Long> rightMap = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();
            if(rightMap.containsKey(baseNumber)) {
                rightMap.put(baseNumber, rightMap.get(baseNumber) + 1);
            } else
                rightMap.put(baseNumber, 1L);
        }

        Map<Long, Long> leftMap = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();

            if (rightMap.containsKey(baseNumber)) {
                if(rightMap.get(baseNumber) == 1)
                    rightMap.remove(baseNumber);
                else
                    rightMap.put(baseNumber, rightMap.get(baseNumber) - 1);
            }

            if(baseNumber % ratio == 0) {
                long div = baseNumber / ratio;
                long multiple = baseNumber * ratio;
                if(div>0) {
                    if (rightMap.containsKey(multiple) && leftMap.containsKey(div))
                        numOfTriplets += rightMap.get(multiple) * leftMap.get(div);
                }
            }

            if (leftMap.containsKey(baseNumber))
                leftMap.put(baseNumber, leftMap.get(baseNumber) + 1);
            else
                leftMap.put(baseNumber, 1L);
        }

        return numOfTriplets;
    }
}
