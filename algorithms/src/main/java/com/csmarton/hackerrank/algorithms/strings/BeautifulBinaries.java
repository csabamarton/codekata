package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;

public class BeautifulBinaries {

	private String number;

	private final static String UGLY_NUMBER = "010";

	public static void main(String[] args)
	{

		BeautifulBinaries beautifulBinaries = new BeautifulBinaries();

		beautifulBinaries.setInputData();
		beautifulBinaries.solve();
	}

	private void setInputData()
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		number = in.next();
	}

	private void solve()
	{
		boolean stillFound = true;

		int numOfProcess = 0;
		while (stillFound) {
			stillFound = findAndChange();
			if (stillFound) {
				numOfProcess++;
			}
		}

		System.out.print(numOfProcess);
	}

	private boolean findAndChange()
	{
		int firstPosition = number.indexOf(UGLY_NUMBER);

		if (firstPosition == -1) {
			return false;
		} else {
			if (number.length() == 3) {
				number = "";
			} else {
				number = number.substring(firstPosition + 3);
			}
		}

		return true;
	}
}
