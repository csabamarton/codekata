package com.csmarton.hackerrank.algorithms.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = target - numbers[i];
            indexMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if(indexMap.containsKey(target - numbers[i]) && indexMap.get(target - numbers[i]) != i)
                return new int[] {i, indexMap.get(target - numbers[i])};
        }

        return null;
    }

    public int[] solution2(int[] numbers, int target) {
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;

        boolean foundSum = false;

        while (!foundSum) {
            int leftNumber = numbers[left];
            int rightNumber = numbers[right];

            if(leftNumber + rightNumber == target){
                return new int[]{left, right};
            }
            if(numbers[left + 1] - leftNumber > numbers[right] - numbers[right - 1]) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1,-1};
    }
}
