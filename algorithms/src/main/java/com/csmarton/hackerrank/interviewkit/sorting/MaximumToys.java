package com.csmarton.hackerrank.interviewkit.sorting;

import java.util.Collections;
import java.util.List;

public class MaximumToys {
    public int solution(List<Integer> list, int budget) {
        Collections.sort(list);

        int price = 0;
        for (int i = 0; i < list.size(); i++) {
            price += list.get(i);
            if(price > budget)
                return i;
        }

        return list.size();
    }
}
