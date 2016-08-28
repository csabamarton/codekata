package com.csmarton.hackerrank.algorithms.warmup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args)
	{

		InputStream is = null;

		String input = "6\n" + "-4 3 -9 0 4 1";
		try {
			is = new ByteArrayInputStream(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Scanner in = new Scanner(is);

		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		int numOfPositives = 3;
		int numOfNegatives = 2;
		int numOfZeros = 1;

	/*	for (int i = 0; i < n; i++) {
			int num = arr[i];

			if(num == 0) {
				numOfZeros++;
			} else if(num>0){
				numOfPositives++;
			} else {
				numOfNegatives++;
			}
		}*/

		System.out.print(Double.valueOf(numOfPositives/6));
		System.out.print((float)numOfNegatives/6);
		System.out.print(numOfZeros);
	}


}
