package com.csmarton.hackerrank.datastrucure.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwap {
    /**
     * Given an array with n element find the and swap the elements to the right position.
     * Starting from position 0 until reach n-1
     *
     * @param arr
     * @return number of minumum swap for making order (asc) a given unordered array of Integer
     */
    public int solution(int[] arr) {
        int numOfSwap = 0;

        int currentPosition = 0;

        Map<Integer, Integer> numbersWithIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numbersWithIndex.put(arr[i], i);
        }

        while (currentPosition < arr.length) {
            int nextIndex = numbersWithIndex.get(currentPosition + 1);

            if(nextIndex != currentPosition) {
                //swapping array
                int temp = arr[nextIndex];
                arr[nextIndex] = arr[currentPosition];
                arr[currentPosition] = temp;
                //swapping map
                numbersWithIndex.put(temp, currentPosition);
                numbersWithIndex.put(arr[nextIndex], nextIndex);

                numOfSwap++;
            }

            currentPosition++;
        }

        return numOfSwap;
    }
}
