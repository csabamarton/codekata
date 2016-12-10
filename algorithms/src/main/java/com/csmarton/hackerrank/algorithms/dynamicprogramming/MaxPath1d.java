package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.stream.IntStream;

public class MaxPath1d {
	static int[] array = new int[] { 11, 2, 8, 20, 5, 40, 10 };
	static int[] sumArray;
	static int[] tokens;

	public static void main(String[] args)
	{

		int size = array.length;
		sumArray = new int[size];
		tokens = new int[] { Math.min(array[0], array[1]), Math.max(array[0], array[1]) };
		sumArray[0] = array[0] * 2;
		sumArray[1] = sumArray[0] + array[1] * 2;

		IntStream.range(2, size).forEach(i -> calculate(i));

		System.out.println(sumArray);
	}

	private static void calculate(int i)
	{
		int prevSum = sumArray[i - 1];

		int minToken = tokens[0];

		int value = array[i];
		if (value > minToken) {
			sumArray[i] = value * 2 + prevSum - minToken;

			if (value > tokens[1]) {
				tokens[0] = tokens[1];
				tokens[1] = value;
			} else {
				tokens[0] = value;
			}
		} else {
			sumArray[i] = prevSum + value;
		}
	}
}
