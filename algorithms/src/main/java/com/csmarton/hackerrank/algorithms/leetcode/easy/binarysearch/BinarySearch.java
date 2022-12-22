package com.csmarton.hackerrank.algorithms.leetcode.easy.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int start = 0;
        int end = nums.length - 1;

        int middle = (end - start + 1) / 2;

        boolean hasNext = true;
        while (hasNext) {
            if(end - start == 1) {
                if(nums[start] == target)
                    return start;
                if(nums[end] == target)
                    return end;

                return -1;
            }


            int middleNum = nums[middle];
            if(middleNum == target)
                return middle;

            if(middleNum > target){
                end = middle;
            } else
                start = middle;

            middle = (end - start + 1) / 2 + start;
        }

        return -1;
    }
}
