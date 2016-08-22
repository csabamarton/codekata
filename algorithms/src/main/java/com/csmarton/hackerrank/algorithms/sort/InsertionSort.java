package com.csmarton.hackerrank.algorithms.sort;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args)
	{

		String input = "10\n2 3 4 5 6 7 8 9 10 1";
		Scanner in = new Scanner(input);
		short lengthOfArray = in.nextShort();

		short[] array = new short[lengthOfArray];

		for(short i = 0; i < lengthOfArray; i++) {
			array[i] = in.nextShort();
		}

		short v = array[lengthOfArray-1];

		boolean isFirtPlaced = true;

		for(short i = (short)(lengthOfArray-2); i>=0; i--) {
			if(array[i] > v){
				array[i+1] = array[i];
			} else {
				array[i+1] = v;
				printArray(array);

				isFirtPlaced = false;

				break;
			}

			printArray(array);
		}

		if(isFirtPlaced){
			array[0] = v;
			printArray(array);
		}
	}

	private static void printArray(short[] ar)
	{
		for (short n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
