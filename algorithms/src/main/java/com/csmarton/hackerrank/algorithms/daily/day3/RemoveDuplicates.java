package com.csmarton.hackerrank.algorithms.daily.day3;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;


        int left = 0;

        for(int right = 1; right < nums.length; right++) {
            if(nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }

        return left + 1;
    }
}
