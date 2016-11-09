package com.csmarton.hackerrank.datastrucure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class MaximumElement
{
	private static final int PUSH_KEY = 1;
	private static final int POP_KEY = 2;
	private static final int PEEK_KEY = 3;


	static Stack<Integer> numbers = new Stack<>();
	static Stack<Integer> maxs = new Stack<>();

	public static void main(String[] args)
	{
		String input = "68\n" + "1 1\n" + "1 44\n" + "3\n" + "3\n" + "2\n" + "3\n" + "3\n" + "1 3\n"
				+ "1 37\n" + "2\n" + "3\n" + "1 29\n" + "3\n" + "1 73\n" + "1 51\n" + "3\n" + "3\n"
				+ "3\n" + "1 70\n" + "3\n" + "1 8\n" + "2\n" + "1 49\n" + "1 56\n" + "1 81\n"
				+ "2\n" + "1 59\n" + "1 44\n" + "2\n" + "3\n" + "3\n" + "2\n" + "3\n" + "3\n"
				+ "1 4\n" + "3\n" + "1 89\n" + "2\n" + "1 37\n" + "1 50\n" + "1 64\n" + "2\n"
				+ "1 49\n" + "1 35\n" + "1 85\n" + "3\n" + "1 41\n" + "2\n" + "3\n" + "3\n"
				+ "1 86\n" + "3\n" + "1 60\n" + "1 8\n" + "3\n" + "1 100\n" + "3\n" + "1 83\n"
				+ "3\n" + "1 47\n" + "2\n" + "1 78\n" + "2\n" + "1 55\n" + "1 97\n" + "2\n" + "3\n"
				+ "1 40";

		Scanner in = new Scanner(input);

		int numOfQueries = in.nextInt();

		IntStream.range(0, numOfQueries).forEach(counter -> query(in));
	}

	private static void query(Scanner in) {

		Map<String, Integer> map = new HashMap<>();

		for(Map.Entry<String, Integer> entry : map.entrySet()) {

		}

		int typeOfQuery = in.nextInt();

		switch (typeOfQuery) {
			case PUSH_KEY: {
				int newNumber = in.nextInt();
				numbers.push(newNumber);
				if(maxs.isEmpty()){
					maxs.push(newNumber);
					break;
				}

				Integer curMax = maxs.peek();

				if(curMax < newNumber) {
					maxs.push(newNumber);
				} else {
					maxs.push(curMax);
				}

				break;
			}
			case POP_KEY: {
				numbers.pop();
				maxs.pop();

				break;
			}
			case PEEK_KEY: {
				System.out.println(maxs.peek());
				break;
			}
		}
	}
}
