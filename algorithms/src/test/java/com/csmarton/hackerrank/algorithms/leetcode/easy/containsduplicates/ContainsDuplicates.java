package com.csmarton.hackerrank.algorithms.leetcode.easy.containsduplicates;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctNums = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(distinctNums.contains(nums[i]))
                return true;
            distinctNums.add(nums[i]);
        }

        return false;
    }
}
