package com.csmarton.hackerrank.algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class MaxModSum {

	private class TestCase {
		private int mod;
		private long[] numbers;

		public TestCase(int mod, long[] numbers)
		{
			this.mod = mod;
			this.numbers = numbers;
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		MaxModSum maxModSum = new MaxModSum();

		maxModSum.start();
	}

	private void start() throws FileNotFoundException
	{

		String input = "1\n" + "100 1399760164\n"
				+ "354724723 116663117 1885681600 474513639 2048518168 1798715778 1154451359 560856756 1265212167 1048886968 639685644 1765763845 1962254641 1433464549 499924441 1054240376 1022523980 388882895 1541208731 970773431 1604797159 1508755786 352886413 1673921314 1488688549 422151782 1680803283 240145938 743965900 1827917457 1639906102 1098690623 1944580573 1378104053 1573204261 1845615092 1029336182 580171972 258988200 147064700 1629058939 898673843 1912828544 1443829931 184654743 265269336 350586658 1207178723 654152230 1891795388 30468505 111465741 1253067526 383354917 1785387054 594272426 805506698 1318706689 834418363 1549472597 999140497 326840816 500679571 796237422 1704944868 2073883832 494368865 586797401 506572155 753357064 733862100 2135631093 1652030907 499206995 1431977375 1836685649 764476331 1782564032 896380723 1418628560 1526875771 926849227 1530094300 632459648 1310204143 1167997706 1226732073 2115710840 339220746 2061150436 1517699789 1338361242 240507603 2018379359 2134598663 1945452471 1944779542 481483880 384766223 303868048";

		  input = "1\n" + "5 7\n" + "3 3 9 9 5";

		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("maxmodsum/input02.txt").getFile());

		Scanner in = new Scanner(file);
		int numOfTestCases = in.nextInt();

		IntStream.range(0, numOfTestCases).forEach(i -> solve(in));

	}

	private void solve(Scanner in)
	{
		TestCase testCase = initTestCase(in);

		/*OptionalLong max = IntStream.range(0, testCase.numbers.length)
				.mapToLong(testSize -> investigateWithSize(testSize, testCase)).max();
		if (max.isPresent()) {
			System.out.println(max.getAsLong());
		}*/
        System.out.println(investigate(testCase));

//		System.out.println(counter);
	}

	/*
	 * private long investigateWithSize(int testSize, TestCase testCase) {
	 * 
	 * long[] numbers = testCase.numbers;
	 * 
	 * long maxSumMod = 0; int mod = testCase.mod;
	 * 
	 * 
	 * for (int i = 0; i <= numbers.length - testSize; i++) { long sum = 0; for (int j = i; j <
	 * i+testSize; j++) { sum = sum + numbers[j];
	 * 
	 * if(sum > mod){ sum = sum - mod; } else if(sum == mod){ sum = 0; } }
	 * 
	 * if(sum > maxSumMod){ maxSumMod = sum; } }
	 * 
	 * return maxSumMod; }
	 */

	private long counter = 0;

	private long investigateWithSize(int start, TestCase testCase)
	{

		long[] numbers = testCase.numbers;

		long maxSumMod = 0;
		int mod = testCase.mod;

		for (int i = start; i < numbers.length; i++) {
			long sum = 0;
			for (int j = i; j < numbers.length; j++) {
				counter++;
				sum = sum + numbers[j];

				if (sum > mod) {
					sum = sum - mod;
				} else if (sum == mod) {
					sum = 0;
				}

				if (sum > maxSumMod) {
					maxSumMod = sum;
				}
			}
		}

		return maxSumMod;
	}

	private long investigate(TestCase testCase)
	{
		long[] numbers = testCase.numbers;

		long maxSumMod = 0;
		int mod = testCase.mod;

		long[] sumMods = numbers.clone();

		int sizeOfArray = numbers.length;

		OptionalLong max = IntStream.range(0, sizeOfArray).mapToLong(i -> sumMods[i]).max();

		maxSumMod = max.getAsLong();

		for (int testLength = 1; testLength <= sizeOfArray; testLength++) {
			for (int i = 0; i < sizeOfArray; i++) {
				if (i + testLength >= sizeOfArray) {
                    break;
				}

				long nextElement = numbers[i + testLength];

                long sum = sumMods[i] + nextElement;

                if (sum > mod) {
                    sum = sum - mod;
                } else if (sum == mod) {
                    sum = 0;
                }
                sumMods[i] = sum;

                if (sum > maxSumMod) {
                    maxSumMod = sum;
                }
			}

		}

		return maxSumMod;
	}

	private TestCase initTestCase(Scanner in)
	{
		int sizeOfArray = in.nextInt();
		int mod = in.nextInt();

		long[] numbers = new long[sizeOfArray];

		IntStream.range(0, sizeOfArray)
				.forEach(i -> numbers[i] = reduceWithMod(in.nextLong(), mod));

		return new TestCase(mod, numbers);
	}

	private long reduceWithMod(long number, int mod)
	{
		if (number > mod) {
			return number % mod;
		}

		return number;
	}
}
