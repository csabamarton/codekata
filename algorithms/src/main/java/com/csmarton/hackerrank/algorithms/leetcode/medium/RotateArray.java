package com.csmarton.hackerrank.algorithms.leetcode.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int hold = nums[0];
        nums[0] = -1;
        int length = nums.length;
        k = k % length;

        int index = k;

        if(k == length)
            return;

        int count = 0;

        while (count < length) {
            if(index >= length)
                index -= length;
            int temp = nums[index];
            nums[index] = hold;
            hold = temp;

            count++;
            if(count == length) {
                break;
            }
            if(hold == -1) {
                index++;
                hold = nums[index];
                nums[index] = -1;
            }

            index += k;
        }
    }
}
