package com.csmarton.hackerrank.algorithms.leetcode.easy.binarysearch;

import java.util.List;

public class DebugBadVersion {

    List<Boolean> versions = List.of(true, true, true, false, false);

    public int firstBadVersion(int n) {
        int left = 1, right = n;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean isBadVersion(int index) {
        return versions.get(index);
    }
}
