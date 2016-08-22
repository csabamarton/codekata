package com.csmarton.hackerrank.week22;

import java.util.Scanner;

public class CookieParty {
	public static void main(String[] args)
	{
		String input = "3 6";

		Scanner in = new Scanner(input);

		int numOfGuests = in.nextInt();
		int numOfCookies = in.nextInt();

		int remain = numOfCookies % numOfGuests;
		if (remain != 0) {
			System.out.println(numOfGuests - remain);
		} else {
			System.out.println(0);
		}

	}
}
