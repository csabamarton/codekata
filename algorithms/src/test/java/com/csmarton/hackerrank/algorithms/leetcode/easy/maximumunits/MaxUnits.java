package com.csmarton.hackerrank.algorithms.leetcode.easy.maximumunits;

import java.util.Arrays;
import java.util.Comparator;

public class MaxUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return 0;
                return o1[1] < o2[1] ? 1 : -1;
            }
        });

        int maxUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int[] currUnits = boxTypes[i];
            if(truckSize <= currUnits[0]) {
                maxUnits = maxUnits + truckSize * currUnits[1];
                return maxUnits;
            } else {
                maxUnits = maxUnits + currUnits[0] * currUnits[1];
                truckSize = truckSize - currUnits[0];
            }
        }

        return maxUnits;
    }
}
