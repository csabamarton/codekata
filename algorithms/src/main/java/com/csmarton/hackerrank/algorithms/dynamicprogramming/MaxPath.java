package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxPath {
	private int[][] array;
	private int[][] sumArray;
	private int size;
	int[] startPos;

	public static void main(String[] args)
	{
		MaxPath maxPath = new MaxPath();

		int[][] array = maxPath.createMatrix();

		int oneTokenSolution = maxPath.solveWithOneToken(array);
		System.out.println(oneTokenSolution);

		int twoTokenSolution = maxPath.solveWithTwoToken(array);
		System.out.println(twoTokenSolution);
	}

    private int solveWithOneToken(int[][] apples)
    {
        initGlobalFields(apples);

        findMaxRoute();

        return sumArray[0][size - 1];
    }

    private int solveWithTwoToken(int[][] apples)
	{
		initGlobalFields(apples);

		int sum = 0;

		findMaxRoute();

		sum += sumArray[0][size - 1];

		clearThePath();

		findMaxRoute();

		sum += sumArray[0][size - 1];

		return sum;
	}

	private void initGlobalFields(int[][] apples)
	{
		array = apples;
		size = array[0].length;
		startPos = new int[] { size - 1, 0 };
		sumArray = new int[size][size];
	}

	private void clearThePath()
	{
		startPos = new int[] { 0, size - 1 };
		array[startPos[0]][startPos[1]] = 0;

		while (!(startPos[0] == size - 1 && startPos[1] == 0)) {
			if (startPos[0] == size - 1) {
				startPos[1] -= 1;
			} else if (startPos[1] == 0) {
				startPos[0] += 1;
			} else {
				int leftValue = sumArray[startPos[0]][startPos[1] - 1];
				int downValue = sumArray[startPos[0] + 1][startPos[1]];

				if (leftValue > downValue) {
					startPos[1] -= 1;
				} else {
					startPos[0] += 1;
				}
			}

			array[startPos[0]][startPos[1]] = 0;
		}

	}

	private void findMaxRoute()
	{
		sumArray = new int[size][size];
		sumArray[size - 1][0] += array[size - 1][0];

		while (!(startPos[0] == 0 && startPos[1] == size - 1)) {
			updateSumValues();
			moveDiagonalStart();
		}
	}

	private void updateSumValues()
	{
		int xPos = startPos[1];
		int yPos = startPos[0];

		while (yPos < size && xPos < size) {
			updateCell(xPos, yPos);
			xPos++;
			yPos++;
		}
	}

	private void updateCell(int xPos, int yPos)
	{
		if (yPos > 0) {
			int upValue = sumArray[yPos - 1][xPos];
			int newValue = sumArray[yPos][xPos] + array[yPos - 1][xPos];
			if (upValue < newValue) {
				sumArray[yPos - 1][xPos] = newValue;
			}
		}

		if (xPos < size - 1) {
			int rightValue = sumArray[yPos][xPos + 1];
			int newValue = sumArray[yPos][xPos] + array[yPos][xPos + 1];
			if (rightValue < newValue) {
				sumArray[yPos][xPos + 1] = newValue;
			}
		}
	}

	private void moveDiagonalStart()
	{
		if (startPos[0] == 0) {
			startPos[1] += 1;
		} else {
			startPos[0] -= 1;
		}
	}

	private int[][] createMatrix()
	{
		String input = "3\n" + "4 0 1\n" + "1 0 0\n" + "0 4 0";
		//String input = "3\n" + "4 2 1\n" + "1 4 1\n" + "0 4 0";

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
