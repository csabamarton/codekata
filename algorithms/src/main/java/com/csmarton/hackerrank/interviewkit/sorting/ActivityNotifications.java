package com.csmarton.hackerrank.interviewkit.sorting;

import java.util.*;
import java.util.stream.IntStream;

public class ActivityNotifications {

    public int solution(List<Integer> expenditure, int days) {
        int numOfNotice = 0;

        List<Integer> subList = new ArrayList<>();
        IntStream.range(0, days).forEach(i-> subList.add(expenditure.get(i)));

        Collections.sort(subList);
        for (int i = 0; i < expenditure.size() - days; i++) {
            double median = findMedian(subList);
            Integer nextExpense = expenditure.get(i + days);
            if(median * 2 <= nextExpense)
                numOfNotice++;


            subList.remove(expenditure.get(i));
            int index = 0;
            boolean foundPosition = false;
            while (!foundPosition && index < subList.size()) {
                if(subList.get(index) > nextExpense) {
                    foundPosition = true;
                } else {
                    index++;
                }
            }
            if(foundPosition)
                subList.add(index,nextExpense);
            else
                subList.add(nextExpense);
        }

        return numOfNotice;
    }

    private double findMedian(List<Integer> expenditure) {
        int low = expenditure.size() / 2;
        if(expenditure.size() % 2 == 0) {
            return (double) (expenditure.get(low - 1) + expenditure.get(low)) / 2;
        }

        return expenditure.get(low);
    }
}
