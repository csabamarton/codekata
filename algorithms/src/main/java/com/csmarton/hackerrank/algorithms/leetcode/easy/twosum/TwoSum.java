package com.csmarton.hackerrank.algorithms.leetcode.easy.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> inverse = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            inverse.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (inverse.containsKey(nums[i]) && inverse.get(nums[i]) != i)
                return new int[]{i, inverse.get(nums[i])};
        }

        return new int[]{};
    }
}
