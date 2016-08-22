package com.csmarton.hackerrank.algorithms.implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AngryProfessor {
	public static void main(String[] args)
	{
		String input = "2\n" + "4 3\n" + "-1 -3 4 2\n" + "4 2\n" + "0 -1 2 1";

		Scanner in = new Scanner(input);
		int t = in.nextInt();
		List<Integer> arrivals = new LinkedList<Integer>();

		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int cancelationLimit = in.nextInt();

			arrivals.clear();

			for (int a_i = 0; a_i < n; a_i++) {
				arrivals.add(in.nextInt());
			}

			int numOfArrivedStudent = getNumOfArrivedStudents(arrivals);

			if (numOfArrivedStudent < cancelationLimit) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static int getNumOfArrivedStudents(List<Integer> arrivals)
	{
		int numOfArrivedStudent = 0;
		Iterator<Integer> iterator = arrivals.iterator();

		while (iterator.hasNext()) {
			if ((iterator.next() <= 0)) {
				numOfArrivedStudent++;
			}
		}

		return numOfArrivedStudent;
	}
}
