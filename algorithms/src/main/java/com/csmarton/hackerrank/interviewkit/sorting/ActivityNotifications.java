package com.csmarton.hackerrank.interviewkit.sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActivityNotifications {

    public int solution2(List<Integer> expenditure, int days) {
        int numOfNotice = 0;

        List<Integer> medianElement = findMedianElement(days);

        List<Integer> subList = new ArrayList<>();
        IntStream.range(0, days).forEach(i -> subList.add(expenditure.get(i)));
        Collections.sort(subList);

        LinkedList<Integer> linkedList = subList.stream().sorted().collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < expenditure.size() - days; i++) {
            double median = findMedian(linkedList, medianElement);
            Integer nextExpense = expenditure.get(i + days);
            if (median * 2 <= nextExpense)
                numOfNotice++;

            linkedList.remove(expenditure.get(i));
            Optional<Integer> first = linkedList.stream().filter(num -> num > nextExpense).findFirst();
            if (first.isPresent()) {
                int index = find_index(linkedList, nextExpense);
                linkedList.add(index, nextExpense);
            }
            else
                linkedList.add(nextExpense);
        }

        return numOfNotice;

    }

    static int find_index(LinkedList<Integer> list, int K)
    {

        // Lower and upper bounds
        int start = 0;
        int end = list.size() - 1;

        // Traverse the search space
        while (start <= end)
        {
            int mid = (start + end) / 2;

            // If K is found
            if (list.get(mid) == K)
                return mid;

            else if (list.get(mid) < K)
                start = mid + 1;

            else
                end = mid - 1;
        }

        // Return insert position
        return end + 1;
    }


    public int solution(List<Integer> expenditure, int days) {
        int numOfNotice = 0;

        List<Integer> subList = new ArrayList<>();
        IntStream.range(0, days).forEach(i -> subList.add(expenditure.get(i)));

        Collections.sort(subList);
        for (int i = 0; i < expenditure.size() - days; i++) {
            double median = findMedian(subList);
            Integer nextExpense = expenditure.get(i + days);
            if (median * 2 <= nextExpense)
                numOfNotice++;

            subList.remove(expenditure.get(i));

            int index = 0;
            boolean foundPosition = false;
            while (!foundPosition && index < subList.size()) {
                if (subList.get(index) > nextExpense) {
                    foundPosition = true;
                } else {
                    index++;
                }
            }
            if (foundPosition)
                subList.add(index, nextExpense);
            else
                subList.add(nextExpense);
        }

        return numOfNotice;
    }

    private double findMedian(List<Integer> expenditure) {
        int low = expenditure.size() / 2;
        if (expenditure.size() % 2 == 0) {
            return (double) (expenditure.get(low - 1) + expenditure.get(low)) / 2;
        }

        return expenditure.get(low);
    }

    private List<Integer> findMedianElement(Integer trailSize) {
        int low = trailSize / 2;
        if (trailSize % 2 == 0) {
            return List.of(low - 1, low);
        }

        return List.of(low);
    }

    private double findMedian(LinkedList<Integer> linkedList, List<Integer> medianPositions) {
        if (medianPositions.size() == 2) {
            return (double) (linkedList.get(medianPositions.get(0)) + linkedList.get(medianPositions.get(1))) / 2;
        }

        return linkedList.get(medianPositions.get(0));
    }
}
