package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args)
	{
		String input = "SOSSPSSQSSOR";

		Scanner in = new Scanner(input);
		String s = in.next();

		char[] chars = s.toCharArray();

		int numOrErrors = 0;

		int counter = 1;
		for(int i = 0; i< chars.length; i++) {
			char letter = chars[i];

			if((counter == 1 || counter == 3) && letter != 'S') {
				numOrErrors++;
			} else if(counter == 2 && letter != 'O') {
				numOrErrors++;
			}

			if(counter == 3){
				counter = 1;
			} else {
				counter++;
			}
		}

		System.out.print(numOrErrors);
	}
}
