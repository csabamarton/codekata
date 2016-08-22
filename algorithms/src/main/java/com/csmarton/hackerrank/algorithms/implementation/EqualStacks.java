package com.csmarton.hackerrank.algorithms.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EqualStacks {
	public static void main(String[] args)
	{
		String input = "5 3 4\n" + "3 2 1 1 1\n" + "4 3 2\n" + "1 1 4 1";

		Scanner in = new Scanner(input);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();

		List[] columns = new List[3];

		int[] heights = new int[3];

		setStackParameters(in, n1, columns, heights, 1);
		setStackParameters(in, n2, columns, heights, 2);
		setStackParameters(in, n3, columns, heights, 3);


		while (!checkEqualilty(heights)) {
			int indexOfHeigthestColumn = getHeightestCylinder(heights);

			Integer topCylinder = (Integer)columns[indexOfHeigthestColumn].remove(0);
			int height = heights[indexOfHeigthestColumn];

			heights[indexOfHeigthestColumn] = height - topCylinder;
		}

		System.out.print(heights[0]);
	}

	private static boolean checkEqualilty(int[] heights) {
		for (int i = 1; i < heights.length; i++) {
			if(heights[i-1] != heights[i])
				return false;
		}

		return true;
	}

	private static int getHeightestCylinder(int[] heights) {
		int indexOfHeightest = -1;
		int maxHeight = -1;

		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			if(height > maxHeight){
				maxHeight = height;
				indexOfHeightest = i;
			}
		}

		return indexOfHeightest;
	}

	private static void setStackParameters(Scanner in, int numOfCylinders, List[] coulumns, int[] heights, int numOfColumn)
	{
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		int heightOfColumn = 0;

		for(int h1_i = 0; h1_i < numOfCylinders; h1_i++){
			int height = in.nextInt();
			stack.add(height);
			heightOfColumn = heightOfColumn + height;
		}

		heights[numOfColumn-1] = heightOfColumn;
		coulumns[numOfColumn-1] = stack;
	}
}
