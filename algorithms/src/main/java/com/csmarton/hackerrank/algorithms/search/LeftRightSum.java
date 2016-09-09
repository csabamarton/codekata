package com.csmarton.hackerrank.algorithms.search;

import java.util.*;
import java.util.stream.IntStream;

public class LeftRightSum {

    private int[] leftSums;
    private  int[] rightSums;

	private Scanner in;
	private List<Integer> numbers;

	private void setInputData()
	{
		int sizeOfArray = in.nextInt();
		numbers = new ArrayList<>(sizeOfArray);

        leftSums = new int[sizeOfArray];
        rightSums = new int[sizeOfArray];

        leftSums[0] = 0;
        rightSums[sizeOfArray-1] = 0;

        for(int i = 0; i<sizeOfArray; i++) {
            int number = in.nextInt();
            numbers.add(number);
        }

        for(int i = 1; i<sizeOfArray; i++) {
            leftSums[i] = leftSums[i-1] + numbers.get(i-1);
        }

        for(int i = sizeOfArray-2; i>=0; i--) {
            rightSums[i] = rightSums[i+1] + numbers.get(i+1);
        }
	}

	public static void main(String[] args)
	{
		LeftRightSum leftRightSum = new LeftRightSum();

		leftRightSum.start();
	}

	private void start()
	{
		in = new Scanner(System.in);

        int numOfTests = in.nextInt();

		IntStream.range(0, numOfTests).forEach(counter -> {
			solve();
        });
	}

	private void solve()
	{
		setInputData();

		boolean foundEquals = false;

		int index = 0;

        while (!foundEquals && index < numbers.size()) {
			foundEquals = leftSums[index] == rightSums[index];
			index++;
		}

		if (foundEquals) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
