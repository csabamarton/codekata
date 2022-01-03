package com.csmarton.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchingSocks {
    public int solution(int[] paramArray) {
        Map<Integer, Integer> colorMap = new HashMap<>();

        Arrays.stream(paramArray).boxed().forEach(color -> {
            if(colorMap.containsKey(color)) {
                colorMap.put(color, colorMap.get(color) + 1);
            } else {
                colorMap.put(color, 1);
            }
        });

        int numOfPairedSocks = 0;

        for (Integer value : colorMap.values()) {
            numOfPairedSocks = numOfPairedSocks + value / 2;
        }

        return numOfPairedSocks;
    }
}
