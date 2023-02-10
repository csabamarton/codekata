package com.csmarton.hackerrank.algorithms.leetcode.easy;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0 && firstZero == -1) {
                firstZero = i;
            } else if(firstZero != -1 && num != 0) {
                nums[firstZero] = nums[i];
                nums[i] = 0;
                firstZero++;
            }
        }
    }
}
