package com.csmarton.hackerrank.algorithms.leetcode.searchinsert;

public class SearchInsert {

    public int solution2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length -1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int index;

        if (left <= right) {
            int mid = (right + left) / 2;

            if (target == nums[mid])
                return mid;

            if (target < nums[mid])
                return binarySearch(nums, target, left, mid - 1);
            else
                return binarySearch(nums, target, mid + 1, right);
        } else
            index = left;

        return index;
    }

    public int solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (target > nums[end])
            return nums.length;
        if (target < nums[0])
            return 0;

        while (end - start > 1) {
            int mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                return mid;
            }

            if (target == nums[end])
                return end;
            if (target == nums[start])
                return start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == nums[end])
            return end;
        if (target == nums[start])
            return start;
        if (target < nums[start])
            return start;
        return end;
    }
}
