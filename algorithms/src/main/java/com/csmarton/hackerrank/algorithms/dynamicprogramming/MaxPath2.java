package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxPath2 {

    private int[][] array;
    private int[][] sumArray;
    private int size;
    int[] startPos;

    public static void main(String[] args)
    {
        MaxPath2 maxPath = new MaxPath2();

        //int[][] array = maxPath.generateMatrix(10000);

        int[][] array = maxPath.createMatrix();

        int oneTokenSolution = maxPath.solveWithOneToken(array);
        System.out.println(oneTokenSolution);
    }

    public int solveWithOneToken(int[][] apples)
    {
        initGlobalFields(apples);

        findMaxRoute();

        return sumArray[0][size - 1];
    }

    private void initGlobalFields(int[][] apples)
    {
        array = apples;
        size = array[0].length;
        startPos = new int[] { size - 2, 1};
        sumArray = new int[size][size];
    }

    private void findMaxRoute()
    {
        sumArray = new int[size][size];

        sumArray[size - 1][0] += array[size - 1][0];

        IntStream.range(1, size).forEach(i -> {
            sumArray[size - 1][i] = sumArray[size - 1][i - 1] + array[size - 1][i];

            sumArray[size - i - 1][0] = sumArray[size - i][0] + array[size - i - 1][0];
        });

        while (startPos[1] < size) {
            updateSumValues();
            startPos[1] += 1;
        }
    }

    private void updateSumValues()
    {
        int xPos = startPos[1];
        int yPos = startPos[0];

        while (yPos >= 0) {
            updateInnerCells(xPos, yPos);
            yPos--;
        }
    }

    private void updateInnerCells(int xPos, int yPos)
    {
        int leftValue = sumArray[yPos][xPos - 1];
        int downValue = sumArray[yPos + 1][xPos];

        if(leftValue > downValue) {
            sumArray[yPos][xPos] = leftValue + array[yPos][xPos];
        } else {
            sumArray[yPos][xPos] = downValue + array[yPos][xPos];
        }
    }

    private int[][] generateMatrix(int size) {
        int[][] apples = new int[size][size];

        Random random = new Random();

        IntStream.range(0, size).forEach(row -> {
            IntStream.range(0, size).forEach(column -> {
                apples[row][column] = random.nextInt(1000);
            });
        });

        return apples;
    }

    private int[][] createMatrix()
    {
        //String input = "3\n" + "4 0 1\n" + "1 0 0\n" + "0 4 0";
        // String input = "3\n" + "4 2 1\n" + "1 4 1\n" + "0 4 0";

        String input = "4\n" + "5 20 6 9\n" + "8 1 1 7\n" + "2 5 3 3\n" + "11 2 22 0";

        Scanner in = new Scanner(input);

        int size = in.nextInt();

        int[][] apples = new int[size][size];

        IntStream.range(0, size).forEach(row -> {
            IntStream.range(0, size).forEach(column -> {
                apples[row][column] = in.nextInt();
            });
        });

        return apples;
    }
}
