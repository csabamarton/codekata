 package com.csmarton.hackerrank.algorithms.basic.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class TwoSum {

    public int[] solve(int[] numbers, int target) {

        Map<Integer, Integer> positions = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (positions.containsKey(numbers[i]))
                return new int[]{positions.get(numbers[i]), i};

            positions.put(target - numbers[i], i);
        }

        return null;
    }
}
