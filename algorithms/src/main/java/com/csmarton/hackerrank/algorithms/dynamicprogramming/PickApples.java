package com.csmarton.hackerrank.algorithms.dynamicprogramming;

public class PickApples {
    static int[][] testOrchard = new int[][] {
            {5, 20, 6, 9},
            {8, 1, 1, 7},
            {2, 5, 3, 3},
            {11, 2, 22, 0}
        };

    static int[][] testOrchard2 = new int[][] {
            {0, 0, 20, 0, 0},
            {20, 0, 0, 3, 18},
            {0, 3, 18, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},

    };


    public static void main(String[] args) {
        MaxPath maxPath = new MaxPath();
        int result = maxPath.solveWithOneToken(testOrchard2);
        System.out.println(result);

        int[] path = maxPath.getPath();

        MaxPath1d maxPath1d = new MaxPath1d();
        maxPath1d.createArray(path);
        maxPath1d.solve();

        MaxPathWithTokens maxPathWithTokens = new MaxPathWithTokens();

        result = maxPathWithTokens.solveWithTwoToken(testOrchard2);
        System.out.println(result);

    }
}
