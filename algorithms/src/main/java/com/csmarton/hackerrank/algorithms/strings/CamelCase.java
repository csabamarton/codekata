package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args)
	{
		String input = "saveChangesInTheEditor";
		Scanner in = new Scanner(input);
		String s = in.next();

		char[] chars = s.toCharArray();

		int numOfWords = 1;

		for(int i = 0; i< chars.length; i++){
			if(Character.isUpperCase(chars[i])){
				numOfWords++;
			}
		}

		System.out.print(numOfWords);
	}
}
