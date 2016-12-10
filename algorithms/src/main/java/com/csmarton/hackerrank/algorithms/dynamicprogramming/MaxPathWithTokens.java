package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxPathWithTokens {
    private int[][] array;
    private int[][] sumArray;
    private int[][] tokenColumn;
    private int size;
    int[] startPos;

    public static void main(String[] args)
    {
        MaxPathWithTokens maxPath = new MaxPathWithTokens();

        //int[][] array = maxPath.generateMatrix(10000);

        int[][] array = maxPath.createMatrix();

        int result = maxPath.solveWithTwoToken(array);
        System.out.println(result);
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
        //String input = "3\n" + "4 2 1\n" + "1 4 1\n" + "0 4 0";
        //String input = "3\n" + "0 0 0\n" + "1 3 0\n" + "0 0 0";

        //String input = "4\n" + "5 20 6 9\n" + "8 1 1 7\n" + "2 5 3 3\n" + "11 2 22 0";
        String input = "3\n" + "20 0 0\n" + "0 10 14\n" + "0 0 0";

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

    public int solveWithTwoToken(int[][] apples)
    {
        initGlobalFields(apples);

        findMaxRoute();

        return sumArray[0][size - 1];
    }

    private void initGlobalFields(int[][] apples)
    {
        array = apples;
        size = array[0].length;
        startPos = new int[] { size - 1, 0};
        sumArray = new int[size][size];

        tokenColumn = new int[size][2];

        IntStream.range(0, size).forEach(row -> {
            tokenColumn[row] = new int[]{-1, -1};
        });

    }

    private void findMaxRoute()
    {
        sumArray = new int[size][size];

        sumArray[size - 1][0] += array[size - 1][0] * 2;

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
        int value = array[yPos][xPos];
        int[] tokens;
        if(xPos == 0 && yPos == size - 1) {
            tokenColumn[yPos] = new int[]{-1, value};
            sumArray[0][0] = value * 2;

            return;
        }

        int[] newLeftTokens = new int[2];

        int newValueFromLeft = 0;
        if(xPos > 0) {
            tokens = tokenColumn[yPos];
            int leftMinToken;

            if(Math.min(tokens[0], tokens[1]) == -1) {
                leftMinToken = 0;
            } else {
                leftMinToken = tokens[0];
            }

            if (value > leftMinToken) {
                newValueFromLeft = value * 2 + sumArray[yPos][xPos - 1] - leftMinToken;
                if (value > tokens[1]) {
                    newLeftTokens[0] = tokens[1];
                    newLeftTokens[1] = value;
                } else {
                    newLeftTokens[0] = value;
                    newLeftTokens[1] = tokens[1];
                }
            } else {
                newValueFromLeft = value + sumArray[yPos][xPos - 1];
                newLeftTokens = new int[]{tokens[0], tokens[1]};
            }
        }

        int[] newDownTokens = new int[2];
        int newValueFromDown = 0;

        if (yPos < size - 1) {
            tokens = tokenColumn[yPos + 1];
            int downMinToken;

            if(Math.min(tokens[0], tokens[1]) == -1) {
                downMinToken = 0;
            } else {
                downMinToken = tokens[0];
            }
            if (value > downMinToken) {
                newValueFromDown = value * 2 + sumArray[yPos + 1][xPos] - downMinToken;
                if (value > tokens[1]) {
                    newDownTokens[0] = tokens[1];
                    newDownTokens[1] = value;
                } else {
                    newDownTokens[0] = value;
                    newDownTokens[1] = tokens[1];
                }
            } else {
                newValueFromDown = value + sumArray[yPos + 1][xPos];

                newDownTokens = new int[]{tokens[0], tokens[1]};
            }
        }

        if(newValueFromLeft > newValueFromDown) {
            tokenColumn[yPos] = newLeftTokens;
            sumArray[yPos][xPos] = newValueFromLeft;
        } else {
            tokenColumn[yPos] = newDownTokens;
            sumArray[yPos][xPos] = newValueFromDown;
        }
    }
}
