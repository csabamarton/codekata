package com.csmarton.hackerrank.algorithms.leetcode.searchinsert;

public class SearchInsert {
    public int solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if(target > nums[end])
            return nums.length;
        if (target < nums[0])
            return 0;

        while (end - start > 1) {
            int mid = (end-start) / 2 + start;

            if(nums[mid] == target){
                return mid;
            }

            if (target == nums[end])
                return end;
            if (target == nums[start])
                return start;
            if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == nums[end])
            return end;
        if (target == nums[start])
            return start;
        if(target<nums[start])
            return start;
        return end;
    }
}
