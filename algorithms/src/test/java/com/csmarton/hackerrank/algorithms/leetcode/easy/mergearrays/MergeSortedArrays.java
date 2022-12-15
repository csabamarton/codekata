package com.csmarton.hackerrank.algorithms.leetcode.easy.mergearrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < nums2.length; i++) {
            nums1[nums1.length - nums2.length + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = nums1.length - 1;
        m--;
        n--;

        while (lastIndex >= 0 && n >= 0) {
            if(m == -1) {
                nums1[lastIndex] = nums2[n];
                lastIndex--;
                n--;
                continue;
            }
            int num1 = nums1[m];
            int num2 = nums2[n];

            if(num1 > num2) {
                nums1[m] = nums1[lastIndex];
                nums1[lastIndex] = num1;
                lastIndex--;
                m--;
            } else {
                nums1[lastIndex] = nums2[n];
                lastIndex--;
                n--;
            }
        }
    }
}
