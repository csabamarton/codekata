package com.csmarton.hackerrank.algorithms.leetcode.easy;

public class DeleteNotSortedColumns {

    public int minDeletionSize(String[] strs) {
        int numOfDeletedColumns = 0;
        int numOfColumns = strs[0].length();
        int numOfRows = strs.length;

        for (int i = 0; i < numOfColumns; i++) {
            char prev = 'a';
            for (int j = 0; j < numOfRows; j++) {
                char next = strs[j].charAt(i);
                if(prev > next) {
                    numOfDeletedColumns++;
                    break;
                }
                prev = next;
            }
        }
        return numOfDeletedColumns;
    }

}
