package com.csmarton.hackerrank.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunnyString {

	private String[] words;

	public String[] getWords()
	{
		return words;
	}

	public void setWords(String[] words)
	{
		this.words = words;
	}

	public static void main(String[] args)
	{
		FunnyString funnyString = new FunnyString();
		funnyString.setInputData();
		funnyString.solve();
	}

	protected void setInputDataFromFile(String path) throws FileNotFoundException
	{
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());

		Scanner in = new Scanner(file);

		setWords(in);

	}

	private void solve()
	{
		for (int i = 0; i < words.length; i++) {
			if(solve(words[i])){
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}
		}
	}

	protected void setInputData()
	{
		Scanner in = new Scanner(System.in);
		setWords(in);
	}

	private void setWords(Scanner in)
	{
		int numOfTestCases = in.nextInt();

		words = new String[numOfTestCases];

		for (int i = 0; i < numOfTestCases; i++) {
			words[i] = in.next();
		}
	}

	protected boolean solve(String word)
	{
		int lengthOfWord = word.length();

		int halfSize = word.length() / 2;
		for (int i = 0; i < halfSize; i++) {
			int reversIndex = lengthOfWord-i-1;

			char letter1 = word.charAt(i);
			char letter2 = word.charAt(i+1);

			char reverseLetter1 = word.charAt(reversIndex);
			char reverseLetter2 = word.charAt(reversIndex-1);

			int distanceBetweenLetters = getDistanceBetweenLetters(letter1, letter2);
			int distanceBetweenReverseLetters = getDistanceBetweenLetters(reverseLetter1, reverseLetter2);

			if(distanceBetweenLetters != distanceBetweenReverseLetters){
				return false;
			}
		}

		return true;
	}

	protected int getDistanceBetweenLetters(char first, char second){
		return Math.abs(first-second);
	}
}
