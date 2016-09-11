package com.csmarton.hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MaxModSum2 {

	public static void main(String[] args) throws Exception{

        MaxModSum2 maxModSum2 = new MaxModSum2();

        ClassLoader classLoader = maxModSum2.getClass().getClassLoader();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(classLoader.getResource("maxmodsum/input14.txt").getFile())));
        Long times = Long.valueOf(in.readLine());

        while(times --> 0){
            long[] pair = Stream.of(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long mod = pair[1];
            long[] numbers = Stream.of(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            printMaxMod(numbers,mod);
        }
    }

	private static void printMaxMod(long[] numbers, Long mod)
	{

		Long maxSoFar = (numbers[numbers.length - 1] + numbers[numbers.length - 2]) % mod;
		maxSoFar = (maxSoFar > (numbers[0] % mod)) ? maxSoFar : numbers[0] % mod;
		numbers[0] %= mod;
		for (Long i = 1L; i < numbers.length; i++) {
			long currentNumber = numbers[i.intValue()] % mod;
			maxSoFar = maxSoFar > currentNumber ? maxSoFar : currentNumber;
			numbers[i.intValue()] = (currentNumber + numbers[i.intValue() - 1]) % mod;
			maxSoFar = maxSoFar > numbers[i.intValue()] ? maxSoFar : numbers[i.intValue()];
		}

		if (mod.equals(maxSoFar + 1) || numbers.length == 2) {
			System.out.println(maxSoFar);
			//return;
		}

		long previousNumber = numbers[0];
		TreeSet<Long> set = new TreeSet<>();
		set.add(previousNumber);

		for (Long i = 2L; i < numbers.length; i++) {
			Long currentNumber = numbers[i.intValue()];
			Long ceiling = set.ceiling(currentNumber);
			if (ceiling == null) {
				set.add(numbers[i.intValue() - 1]);
				continue;
			}

			if (ceiling.equals(currentNumber)) {
				set.remove(ceiling);
				Long greaterCeiling = set.ceiling(currentNumber);
				if (greaterCeiling == null) {
					set.add(ceiling);
					set.add(numbers[i.intValue() - 1]);
					continue;
				}
				set.add(ceiling);
				ceiling = greaterCeiling;
			}
			Long newMax = (currentNumber - ceiling + mod);
			maxSoFar = maxSoFar > newMax ? maxSoFar : newMax;
			set.add(numbers[i.intValue() - 1]);
		}

		System.out.println(maxSoFar);

	}

}