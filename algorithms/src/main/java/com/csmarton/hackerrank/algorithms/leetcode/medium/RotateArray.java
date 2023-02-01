package com.csmarton.hackerrank.algorithms.leetcode.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int hold = nums[0];
        int length = nums.length;
        k = k % length;

        int index = k;

        if(k == length)
            return;

        boolean hasToJump = length % k == 0;

        int oneIteration = (int)Math.ceil((double)length / k);

        int count = 0;

        while (count < length) {
            for (int i = 0; i < oneIteration; i++) {
                if(index >= length)
                    index -= length;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;

                index += k;
                count++;
                if(count == length) {
                    break;
                }
            }

            if (hasToJump) {
                index = index - k + 1;
                hold = nums[index];
                index = index + k;
            }
        }
    }
}
