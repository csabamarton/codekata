package com.csmarton.hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumDistances {

	public static void main(String[] args)
	{
		String input = "6\n" + "7 1 3 4 1 7";

		Scanner in = new Scanner(input);

		int size = in.nextInt();
		int[] numbers = new int[size];

		for (int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}

		Map<Integer, Integer> numberPositions = new HashMap<Integer, Integer>();

		int minDistance = size + 1;

		for (int i = 0; i < size; i++) {
			Integer number = numbers[i];
			if (numberPositions.containsKey(number)) {
				int previousIndex = numberPositions.get(number);
				int distance = i - previousIndex;
				if (minDistance == -1 || minDistance > distance) {
					minDistance = distance;
				}
			}
			numberPositions.put(number, i);
		}

		if (minDistance == (size + 1)) {
			System.out.print(-1);
		} else {
			System.out.print(minDistance);
		}
	}
}
