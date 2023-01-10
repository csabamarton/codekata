package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    enum DIRECTION {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    List<DIRECTION> routes = List.of(DIRECTION.RIGHT, DIRECTION.DOWN, DIRECTION.LEFT, DIRECTION.UP);

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();

        int size = matrix[0].length * matrix.length;
        int numOfVisited = 0;

        int row = 0, column = 0;

        DIRECTION nextWay = DIRECTION.RIGHT;

        while (numOfVisited != size) {
            int num = matrix[row][column];
            nums.add(num);
            matrix[row][column] = 101;
            numOfVisited++;

            int remainingTurn = 3;

            for (int i = 1; i < 5; i++) {
                boolean isValid = whichWay(nextWay, row, column, matrix.length, matrix[0].length, matrix);

                if (!isValid) {
                    if(remainingTurn == 0)
                        return nums;
                    remainingTurn--;

                    if(nextWay == DIRECTION.RIGHT) nextWay = DIRECTION.DOWN;
                    else if(nextWay == DIRECTION.DOWN) nextWay = DIRECTION.LEFT;
                    else if(nextWay == DIRECTION.LEFT) nextWay = DIRECTION.UP;
                    else if(nextWay == DIRECTION.UP) nextWay = DIRECTION.RIGHT;
                }
            }

            if(nextWay == DIRECTION.RIGHT) column++;
            if(nextWay == DIRECTION.DOWN) row++;
            if(nextWay == DIRECTION.LEFT) column--;
            if(nextWay == DIRECTION.UP) row--;

        }

        return nums;
    }

    private boolean whichWay(DIRECTION nextWay, int row, int column, int rowNum, int columnNum, int[][] matrix) {
        if(nextWay == DIRECTION.RIGHT) {
            return column < columnNum - 1 && matrix[row][column + 1] != 101;
        }
        if(nextWay == DIRECTION.DOWN) {
            return row < rowNum - 1 && matrix[row + 1][column] != 101;
        }
        if(nextWay == DIRECTION.LEFT) {
            return column > 0 && matrix[row][column - 1] != 101;
        }
        if(nextWay == DIRECTION.UP) {
            return row > 0 && matrix[row - 1][column] != 101;
        }

        return false;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3}, {4,5,6},{7,8,9}}));
    }
}
