package com.csmarton.hackerrank.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		System.out.print("hello");
		String s = "welcometojava\n" + "3";

		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int lengthOfSub = sc.nextInt();
	}

	public static String read(InputStream input) throws IOException
	{
		/*try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		}*/

		return null;
	}
}
