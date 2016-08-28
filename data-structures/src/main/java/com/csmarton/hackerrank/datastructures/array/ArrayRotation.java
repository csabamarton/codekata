package com.csmarton.hackerrank.datastructures.array;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;

public class ArrayRotation {

	public static void main(String[] args)
	{
		InputStream is = null;
		String input = "3 2 3\n" + "1 2 3\n" + "0\n" + "1\n" + "2";

		try {
			is = new ByteArrayInputStream(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Scanner in = new Scanner(is);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();

		in.nextLine();
		String[] arrayInString = in.nextLine().split(" ");

		LinkedList<Integer> array = new LinkedList<Integer>();
		for (int i = 0; i < arrayInString.length; i++) {
			array.add(Integer.valueOf(arrayInString[i]));
		}

		int[] queries = new int[q];
		for (int i = 0; i < q; i++) {
			queries[i] = in.nextInt();
		}

		for (int i = 0; i < k; i++) {
			rotate(array);
		}

		for (int i = 0; i < q; i++) {
			System.out.println(array.get(queries[i]));
		}

	}

	private static void rotate(LinkedList<Integer> array)
	{
		array.addFirst(array.removeLast());
	}
}
