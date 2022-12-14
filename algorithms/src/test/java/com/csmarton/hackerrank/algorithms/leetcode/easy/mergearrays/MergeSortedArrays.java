package com.csmarton.hackerrank.algorithms.leetcode.easy.mergearrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < nums2.length; i++) {
            nums1[nums1.length - nums2.length + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}
