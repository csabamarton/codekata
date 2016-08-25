package com.csmarton.hackerrank.week22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Polygons
{
	public static void main(String[] args)
	{
		String input = "3\n" + "1 2 3";
		Scanner in = new Scanner(input);

		int n = in.nextInt();
		Float[] a = new Float[n];
		List<Float> list = new ArrayList<Float>();
		for(int a_i=0; a_i < n; a_i++){
			list.add((float)in.nextInt());
		}


		Collections.sort(list);

		float sum = getSum(list);

		int cut = 0;
		while(checkLastNumber(list, sum)) {
			cut++;

			int size = list.size();
			float last = list.get(size-1);

			float half = last/(float)2;
			list.set(size-1, half);

			list.add(half);

			Collections.sort(list);

			sum = getSum(list);
		}

		System.out.print(cut);
	}

	private static boolean checkLastNumber(List<Float> list, float sum)
	{
		int size = list.size();
		float last = list.get(size-1);

		return (sum - last) <= last;
	}

	private static float getSum(List<Float> list) {
		float sum = 0;

		for(int i=0; i < list.size(); i++) {
			sum = sum + list.get(i);
		}

		return sum;
	}
}
