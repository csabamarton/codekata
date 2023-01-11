package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

public class BallDrop {

    public int[] findBall(int[][] grid) {
        int numOfColumns = grid[0].length;
        int[] result = new int[numOfColumns];

        for (int i = 0; i < grid[0].length; i++) {
            result[i] = fall(i, grid, 0);
        }

        return result;
    }

    private int fall(int ballIndex, int[][] grid, int rowIndex) {
        if(rowIndex == grid.length)
            return ballIndex;

        int[] row = grid[rowIndex];

        if(row[ballIndex] == 1) {
            if(ballIndex == row.length - 1 || row[ballIndex + 1] == -1)
                return -1;
            else return fall(ballIndex + 1, grid, rowIndex + 1);
        } else {
            if(ballIndex == 0 || row[ballIndex - 1] == 1)
                return -1;
            else return fall(ballIndex - 1, grid, rowIndex + 1);
        }
    }

    public static void main(String[] args) {
        BallDrop ballDrop = new BallDrop();

        System.out.println(ballDrop.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}}));

    }
}
