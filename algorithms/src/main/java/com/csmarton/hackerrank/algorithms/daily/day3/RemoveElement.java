package com.csmarton.hackerrank.algorithms.daily.day3;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != val )
                nums[left++] = nums[right];
        }

        return left;
    }
}
