package com.csmarton.hackerrank.algorithms.leetcode.easy.pivot;

public class PivotIndex {


    public int pivotIndex(int[] nums) {
        if(nums.length == 1)
            return 0;

        int[] sumFromLeft = new int[nums.length];
        sumFromLeft[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sumFromLeft[i] = sumFromLeft[i - 1] + nums[i];
        }

        int[] sumFromRight = new int[nums.length];
        sumFromRight[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            sumFromRight[i] = sumFromRight[i + 1] + nums[i];
        }

        if(sumFromRight[1] == 0)
                return 0;

        for (int i = 0; i < sumFromLeft.length - 2; i++) {
            if(sumFromLeft[i] == sumFromRight[i + 2])
                return i + 1;
        }

        if(sumFromLeft[sumFromLeft.length - 2] == 0)
            return sumFromLeft.length - 1;

        return -1;
    }

    public int pivotIndex2(int[] nums) {
        if(nums.length < 3)
            return -1;

        int left = 0;
        int right = nums.length - 1;
        int sumLeft = nums[0], sumRight = nums[nums.length - 1];

        while(right - left > 2) {
                if(sumLeft < sumRight) {
                    left++;
                    sumLeft = sumLeft + nums[left];
                } else {
                    right--;
                    sumRight = sumRight + nums[right];
                }
        }

        return sumLeft == sumRight ? left + 1 : -1;
    }
}
