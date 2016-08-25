package com.csmarton.hackerrank.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RichieRich {

	private static final char NINE = '9';
	private String inputNumber;
	private int changeLimit;

	public static void main(String[] args) throws FileNotFoundException
	{
		RichieRich richieRich = new RichieRich();

		richieRich.setInputs("richierich/input.txt");

		richieRich.solve();
	}

	private void solve()
	{
		StringBuilder number = new StringBuilder(getInputNumber());

		int length = number.length();

		List<Integer> positionsOfNeedToChange = getPositionsOfNeedToChange();

		int numOfNecessaryFlip = positionsOfNeedToChange.size();

		if (getChangeLimit() < positionsOfNeedToChange.size()) {
			System.out.print("-1");
		} else {
			for (int i = 0; i <= number.length() / 2; i++) {
				Integer index = i;
				int reverseIndex = length - index - 1;

				int firstNum = Character.getNumericValue(number.charAt(index));
				int secondNum = Character.getNumericValue(number.charAt(reverseIndex));

				boolean notHighestPair = false;
				boolean needToFlip = false;

				if (number.length() % 2 != 0 && number.length() / 2 == index && firstNum != 9
						&& numOfNecessaryFlip <= getChangeLimit() - 1) {
					number.setCharAt(index, NINE);
					continue;
				}

				if (Math.min(firstNum, secondNum) != 9) {
					notHighestPair = true;
				}

				boolean needTwoFlipForNine = false;
				if (Math.max(firstNum, secondNum) != 9) {
					needTwoFlipForNine = true;
				}

				if (firstNum != secondNum) {
					needToFlip = true;
				}

				if (!needToFlip && notHighestPair && numOfNecessaryFlip <= getChangeLimit() - 2) {
					number.setCharAt(index, NINE);
					number.setCharAt(reverseIndex, NINE);

					setChangeLimit(getChangeLimit() - 2);
				} else if (!needToFlip && !notHighestPair) {
					// done
				} else if (needToFlip) {
					if (needTwoFlipForNine && numOfNecessaryFlip <= getChangeLimit() - 1) {
						number.setCharAt(index, NINE);
						number.setCharAt(reverseIndex, NINE);

						setChangeLimit(getChangeLimit() - 2);
					} else {
							if (firstNum > secondNum) {
								number.setCharAt(reverseIndex, Integer.toString(firstNum).charAt(0));
							} else {
								number.setCharAt(index, Integer.toString(secondNum).charAt(0));
							}
							setChangeLimit(getChangeLimit() - 1);
						}

					positionsOfNeedToChange.remove(index);
					numOfNecessaryFlip--;
				}
			}

			System.out.print(number.toString());
		}
	}


	public String getInputNumber()
	{
		return inputNumber;
	}

	public void setInputNumber(String inputNumber)
	{
		this.inputNumber = inputNumber;
	}

	public int getChangeLimit()
	{
		return changeLimit;
	}

	public void setChangeLimit(int changeLimit)
	{
		this.changeLimit = changeLimit;
	}

	protected File getResourceFile(String path)
	{
		return new File(path);
	}

	protected void getInputString(File file) throws FileNotFoundException
	{
		Scanner in = new Scanner(file);

		setInputs(in);
	}

	private void setInputs(Scanner in)
	{
		in.next();
		setChangeLimit(in.nextInt());
		setInputNumber(in.next());
	}

	private void setInputs(String path) throws FileNotFoundException
	{
		URL resource = this.getClass().getClassLoader().getResource(path);

		Scanner in = new Scanner(new File(resource.getFile()));
		in.next();
		setChangeLimit(in.nextInt());
		setInputNumber(in.next());
	}

	public List<Integer> getPositionsOfNeedToChange()
	{

		List<Integer> needToChangePositions = new ArrayList<>();

		for (int i = 0; i < inputNumber.length() / 2; i++) {
			int reverseIndex = inputNumber.length() - i - 1;
			if (getInputNumber().charAt(i) != getInputNumber().charAt(reverseIndex)) {
				needToChangePositions.add(i);
			}
		}

		return needToChangePositions;
	}
}
