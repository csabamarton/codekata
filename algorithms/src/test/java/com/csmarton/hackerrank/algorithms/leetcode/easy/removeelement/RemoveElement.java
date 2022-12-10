package com.csmarton.hackerrank.algorithms.leetcode.easy.removeelement;

public class RemoveElement {
    public int removeElement(int[] nums, final int val) {

        if (nums.length == 0)
            return 0;

        if(nums.length == 1 && val == nums[0]) {
            nums[0] = val + 1;
            return 0;
        }

        if(nums.length == 1 && val != nums[0]) {
            return 1;
        }

        int lastPos = -1;

        for (int i = 0; i <nums.length; i++) {
            if (lastPos == -1 && nums[i] == val) {
                lastPos = i;
                continue;
            }

            if(nums[i] != val && lastPos != -1){
                int temp = nums[i];
                nums[i] = nums[lastPos];
                nums[lastPos] = temp;

                lastPos++;
            }
        }

        if(lastPos == -1) {
            return nums.length;
        }

        return lastPos;
    }
}
