package com.csmarton.hackerrank.algorithms.leetcode.easy.uniqueoccurence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean solution(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            occurMap.put(arr[i] , occurMap.containsKey(arr[i]) ? occurMap.get(arr[i]) + 1 : 1);
        }

        Set<Integer> distictOccurences = new HashSet<>(occurMap.values());

        return occurMap.values().size() == distictOccurences.size();
    }
}
