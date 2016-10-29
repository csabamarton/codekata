package com.csmarton.hackerrank.datastrucure.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayLeftRotation {

	public static Deque<Integer> numbers = new LinkedList<>();

	public static void main(String[] args)
	{
		Scanner in = new Scanner("5 4\n" + "1 2 3 4 5");

		in.nextInt();
		int numOfRotation = in.nextInt();
		in.nextLine();

		while (in.hasNext()) {
			numbers.add(in.nextInt());
		}

		IntStream.range(0, numOfRotation).forEach(i -> {
			numbers.addLast(numbers.pop());
		});

		String formattedList = numbers.stream().map(i -> i.toString())
				.collect(Collectors.joining(" ")).toString();

		System.out.println(formattedList);
	}
}