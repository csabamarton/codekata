package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/majority-element/description/
public class MajorityOfElements {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
