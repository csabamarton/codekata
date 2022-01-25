package com.csmarton.hackerrank.interviewkit.sorting;

import java.util.List;

import static java.util.Collections.swap;

public class CountSwaps {
    public List<String> solution(List<Integer> list) {
        long swapCounter = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                    swapCounter++;
                }
            }
        }

        System.out.println(String.format("Array is sorted in %d swaps.", swapCounter));
        System.out.println(String.format("First Element: %d", list.get(0)));
        System.out.println(String.format("Last Element: %d", list.get(list.size() - 1)));

        return List.of(String.valueOf(swapCounter), list.get(0).toString(), list.get(list.size() - 1).toString());
    }
}
