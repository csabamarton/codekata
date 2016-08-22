package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumSubarray {

	int numOfTestCases;
	Scanner in;

	public static void main(String[] args) throws IOException
	{
		MaximumSubarray maximuSubArray = new MaximumSubarray();

		ClassLoader classLoader = maximuSubArray.getClass().getClassLoader();
		File file = new File(classLoader.getResource("input.txt").getFile());

		Scanner in = new Scanner(file);

		maximuSubArray.in = in;

		maximuSubArray.setTestData();
		maximuSubArray.startTests();
	}

	private void startTests()
	{
		for (int i = 0; i < numOfTestCases; i++) {
			solveTest();
			System.out.println("");
		}
	}

	private void solveTest()
	{
		int size = in.nextInt();

		LinkedList<Short> numbers = new LinkedList<Short>();

		for (int i = 0; i < size; i++) {
			numbers.add(in.nextShort());
		}

		int maxNonContigousSum = getMaxNonContigousSum(numbers);
		int maxContigousSum = getMaxContigousSum(numbers);

		System.out.print(maxContigousSum);
		System.out.print(" ");
		System.out.print(maxNonContigousSum);
	}

	private int getMaxNonContigousSum(LinkedList<Short> numbers)
	{
		Integer maxNumber = Integer.MIN_VALUE;
		int sum = 0;
		Iterator<Short> iterator = numbers.iterator();

		while (iterator.hasNext()) {
			int number = iterator.next();

			if (maxNumber < number) {
				maxNumber = number;
			}

			if (number > 0) {
				sum = sum + number;
			}
		}

		if (sum == 0) {
			return maxNumber;
		}

		return sum;
	}

	public int getMaxContigousSum(LinkedList<Short> numbers)
	{
		Integer maxContigousSum = Integer.MIN_VALUE;

		int size = numbers.size();

		Integer sum;

		for (int i = 0; i < size; i++) {

			Iterator<Short> iterator = numbers.iterator();

			Short next = iterator.next();
			sum = Integer.valueOf(next);

			if (next < 0) {
				if (sum > maxContigousSum) {
					maxContigousSum = sum;
				}
			} else {
				while (iterator.hasNext()) {
					next = iterator.next();

					if (next > 0) {
						sum = sum + next;
						maxContigousSum = sum;
						continue;
					} else if (next < 0 && (sum - next) < 0) {
						break;
					} else {
						sum = sum + next;
					}
					if (sum > maxContigousSum) {
						maxContigousSum = sum;
					}
				}
			}
			numbers.removeFirst();
		}

		return maxContigousSum;
	}

	private void setTestData()
	{
		numOfTestCases = in.nextInt();
	}
}
