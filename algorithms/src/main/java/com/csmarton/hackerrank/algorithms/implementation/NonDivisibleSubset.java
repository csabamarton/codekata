package com.csmarton.hackerrank.algorithms.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.toIntExact;

public class NonDivisibleSubset {

	private List<Integer> numbers = new ArrayList<>();

	private int divider;
	
	private Map<Integer, Long> counted;

	public static void main(String[] args) throws FileNotFoundException
	{
		NonDivisibleSubset nonDivisibleSubset = new NonDivisibleSubset();

		nonDivisibleSubset.setInputData();

		nonDivisibleSubset.start();
	}

	private void start()
	{
		Iterator<Integer> iterator = numbers.iterator();

		Set<Integer> goodNumbers = new HashSet<>();

		if (numbers.contains(0)) {
			goodNumbers.add(iterator.next());
		}

		while (iterator.hasNext()) {
			Integer number = iterator.next();

			int opposite = divider - number;

			if (!goodNumbers.contains(opposite)) {
				if (!numbers.contains(opposite)) {
					goodNumbers.add(number);
				} else {
					if (counted.get(number) > counted.get(opposite)) {
						goodNumbers.add(number);
					} else {
						goodNumbers.add(opposite);
					}
				}
			}
		}

		int sum = goodNumbers.stream().mapToInt(number -> {
			if ((number + number) != divider && number != 0) {
				return toIntExact(counted.get(number));
			} else {
				return 1;
			}
		}).sum();

		System.out.println(sum);
	}

	private void setInputData() throws FileNotFoundException
	{
		URL resource = this.getClass().getClassLoader().getResource("nondivisible/input100000.txt");
		Scanner in = new Scanner(new File(resource.getFile()));

		int numOfNumbers = in.nextInt();

		divider = in.nextInt();

		numbers = IntStream.range(0, numOfNumbers)
						   .mapToObj(i -> in.nextInt())
						   .collect(Collectors.toList());

		reduceNumbers();
	}

	private void reduceNumbers()
	{
		numbers = numbers.stream().map(number -> {
			int newNumber = number % divider;
			return newNumber;
		}).collect(Collectors.toList());

		Collections.sort(numbers);

		counted = numbers.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.counting()));

		if (counted.containsKey(0)) {
			counted.put(0, 1L);
		}

		int middle = divider / 2;

		if (divider % 2 != 1 && counted.containsKey(middle)) {
			counted.put(middle, 1L);
		}

		numbers = numbers.stream().distinct().collect(Collectors.toList());
	}
}
