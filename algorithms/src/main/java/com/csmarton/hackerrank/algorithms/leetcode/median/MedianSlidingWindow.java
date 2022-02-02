package com.csmarton.hackerrank.algorithms.leetcode.median;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedianSlidingWindow {
    public double[] soultion(int[] expenditure, int windowSize) {
        double[] medians;
        int numOfNotice = 0;

        List<Integer> medianElement = findMedianElement(windowSize);

        List<Integer> subList = new ArrayList<>();
        IntStream.range(0, windowSize).forEach(i -> subList.add(expenditure[i]));
        Collections.sort(subList);

        LinkedList<Integer> linkedList = subList.stream().sorted().collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < expenditure.length - windowSize; i++) {
            double median = findMedian(subList, medianElement);
            Integer nextExpense = expenditure[i + windowSize];
            if (median * 2 <= nextExpense)
                numOfNotice++;

            linkedList.remove(expenditure[i]);
            Optional<Integer> first = linkedList.stream().filter(num -> num > nextExpense).findFirst();
            if (first.isPresent()) {
                int index = findInsertPosition(linkedList, nextExpense);
                linkedList.add(index, nextExpense);
            }
            else
                linkedList.add(nextExpense);
        }

        return null;
    }

    private double findMedian(List<Integer> list, List<Integer> medianPositions) {
        if (medianPositions.size() == 2) {
            return (double) (list.get(medianPositions.get(0)) + list.get(medianPositions.get(1))) / 2;
        }

        return list.get(medianPositions.get(0));
    }

    private List<Integer> findMedianElement(Integer trailSize) {
        int low = trailSize / 2;
        if (trailSize % 2 == 0) {
            return List.of(low - 1, low);
        }

        return List.of(low);
    }

    public int findInsertPosition(List<Integer> nums, int target) {
        return binarySearch(nums, target, 0, nums.size() -1);
    }

    private int binarySearch(List<Integer> nums, int target, int left, int right) {
        int index;

        if (left <= right) {
            int mid = (right + left) / 2;

            if (target == nums.get(mid))
                return mid;

            if (target < nums.get(mid))
                return binarySearch(nums, target, left, mid - 1);
            else
                return binarySearch(nums, target, mid + 1, right);
        } else
            index = left;

        return index;
    }
}
