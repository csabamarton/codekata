package com.csmarton.hackerrank.triplets;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
/*		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();
*/
		int a0 = 5;
		int a1 = 6;
		int a2 = 7;
		int b0 = 3;
		int b1 = 6;
		int b2 = 10;

		Challenge challenge = new Challenge();

		challenge.setA(a0, a1, a2);
		challenge.setB(b0, b1, b2);

		startComparing(challenge);

		System.out.print(challenge.getaPoints() + " " + challenge.getbPoints());
	}

	private static void startComparing(Challenge challenge) {
		for (int index = 0; index<3; index++) {
			int compareResult = compareResults(index, challenge);
			if (compareResult < 0) {
				challenge.increasebPoints();
			} else if (compareResult > 0) {
				challenge.increaseaPoints();
			}
		}
	}

	private static int compareResults(int index, Challenge challenge) {
		return challenge.getA(index) - challenge.getB(index);
	}
}

class Challenge {
	private int[] a;
	private int[] b;

	private int aPoints = 0;
	private int bPoints = 0;

	public void setA(int... a) {
		this.a = a;
	}

	public void setB(int... b) {
		this.b = b;
	}

	public int getA(int index)
	{
		return a[index];
	}

	public int getB(int index)
	{
		return b[index];
	}

	public void increaseaPoints(){
		aPoints++;
	}

	public void increasebPoints(){
		bPoints++;
	}

	public int getbPoints()
	{
		return bPoints;
	}

	public int getaPoints()
	{
		return aPoints;
	}
}