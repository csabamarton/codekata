package com.csmarton.hackerrank.algorithms.leetcode.medium.dynamicprogramming;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        paths[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
               if(r == 0 && c == 0) continue;

               paths[r][c] = (r > 0 ? paths [r - 1][c] : 0) + (c > 0 ? paths[r][c -1] : 0);
            }
        }

        return paths[m -1][n -1];
    }
}
