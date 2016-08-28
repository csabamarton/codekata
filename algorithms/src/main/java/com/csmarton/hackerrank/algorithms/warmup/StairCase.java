package com.csmarton.hackerrank.algorithms.warmup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class StairCase {
	static int height;
	public static void main(String[] args) {
		InputStream is = null;

		String input = "10";
		try {
			is = new ByteArrayInputStream(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Scanner in = new Scanner(is);

		int n = in.nextInt();

		height = n;

		draw(height);
	}

	private static void draw(int n) {
		for(int i = 1; i < n; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i<height-n; i++) {
			System.out.print("#");
		}
		System.out.println("");

		if(n>1) {
			draw(n-1);
		}
	}
}
