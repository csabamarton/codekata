package com.csmarton.hackerrank.week22;

import java.math.BigInteger;
import java.util.*;

public class BoxMoving {
	public static void main(String[] args)
	{
		String input = "3\n" + "1 2 3\n" + "-1 4 3";
		input = "6\n" + "1 1 100 2 2 3\n" + "2 2 3 -10 7 105";
		Scanner in = new Scanner(input);

		int n = in.nextInt();

		Integer[] xArray = new Integer[n];
		Integer[] yArray = new Integer[n];

		BigInteger sumX = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			xArray[i] = x;
			sumX = sumX.add(BigInteger.valueOf(x));
		}

		BigInteger sumY = BigInteger.ZERO;

		for (int i = 0; i < n; i++) {
			int y = in.nextInt();
			yArray[i] = y;
			sumY = sumY.add(BigInteger.valueOf(y));
		}

		if (sumX.compareTo(sumY) == 0) {
			List<Integer> xList = Arrays.asList(xArray);
			List<Integer> yList = Arrays.asList(yArray);

			Collections.sort(xList);
			Collections.sort(yList);

			BigInteger positives = BigInteger.ZERO;

			for (int i = 0; i < n; i++) {
				int num = xList.get(i) - yList.get(i);

				if (num > 0) {
					positives = positives.add(BigInteger.valueOf(num));
				}
			}

			System.out.println(positives);
		} else {
			System.out.println(-1);
		}
	}
}
