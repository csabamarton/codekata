package com.csmarton.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class Kangaroo
{
	public static void main(String[] args)
	{
		String input = "43 2 70 2";

		Scanner in = new Scanner(input);
		int kangAPosition = in.nextInt();
		int aSpeed = in.nextInt();
		int kangBPosition = in.nextInt();
		int bSpeed = in.nextInt();

		int distance = Math.abs(kangAPosition - kangBPosition);

		if (distance == 0) {
			System.out.println("YES");
		} else {
			int lastDistance = distance;

			boolean isFirstRun = true;

			while (!(lastDistance < distance) && distance != 0 && !(!isFirstRun
					&& lastDistance == distance)) {
				lastDistance = distance;

				kangAPosition = move(kangAPosition, aSpeed);
				kangBPosition = move(kangBPosition, bSpeed);

				distance = Math.abs(kangAPosition - kangBPosition);

				investigate(distance, lastDistance);

				isFirstRun = false;
			}

			if (!isFirstRun && lastDistance == distance) {
				System.out.println("NO");
			}
		}
	}

	private static void investigate(int distance, int lastDistance)
	{
		if (distance == 0) {
			System.out.println("YES");
		} else if (lastDistance < distance) {
			System.out.println("NO");
		}
	}

	private static int move(int startPosition, int speed)
	{
		return startPosition + speed;
	}
}
