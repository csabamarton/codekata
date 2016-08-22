package com.csmarton.hackerrank.algorithms.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pangrams {

	private String sentence;

	private Pangrams testPangrams;

	private final static String PANGRAM = "pangram";
	private final static String NOT_PANGRAM = "not pangram";
	private final static int NUMBER_OF_ALPHABET_LETTERS = 26;

	@Before
	public void beforeProcess()
	{
		testPangrams = new Pangrams();
	}

	public static void main(String[] args)
	{
		Pangrams pangrams = new Pangrams();

		String input = "We promptly judged antique ivory buckles for the next prize";

		pangrams.solve(input);
	}

	private void solve(String input)
	{
		setInputData(input);

		String cleanSentence = replaceNonAlphabetChars();

		int numOfLetters = process(cleanSentence, NUMBER_OF_ALPHABET_LETTERS);

		if (numOfLetters == NUMBER_OF_ALPHABET_LETTERS) {
			System.out.print(PANGRAM);
		} else {
			System.out.print(NOT_PANGRAM);
		}
	}

	private void setInputData(String input)
	{
		Assert.assertNotNull("Input is empty", input);

		Scanner in = new Scanner(input);
		sentence = in.nextLine();
	}

	private String replaceNonAlphabetChars()
	{
		return sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
	}

	private int process(String input)
	{
		return process(input, null);
	}

	private int process(String input, Integer countLimit)
	{
		List<Character> charsInTheInput = new ArrayList<Character>();

		for (char character : input.toCharArray()) {
			if (countLimit != null && countLimit == charsInTheInput.size()) {
				break;
			}

			if (!charsInTheInput.contains(character)) {
				charsInTheInput.add(character);
			}
		}

		return charsInTheInput.size();
	}

	@Test
	public void checkReadingWithScanner()
	{
		String input = "We promptly judged antique ivory buckles for the next prize";

		testPangrams.setInputData(input);

		Assert.assertEquals("Reading the input went wrong", input, testPangrams.sentence);
	}

	@Test
	public void replaceNonAlphabetCharactersFromOnlySpacesAndUpperCase()
	{
		String input = "We promptly judged antique ivory buckles for the next prize";
		String expectedOutput = "wepromptlyjudgedantiqueivorybucklesforthenextprize";

		testPangrams.setInputData(input);

		String output = testPangrams.replaceNonAlphabetChars();

		Assert.assertEquals("Output after replacing is wrong", output, expectedOutput);
	}

	@Test
	public void replaceNonAlphabetCharactersFromSpacesAndNumbersAndSigns()
	{
		String input = "We2 2promptly judged antique .Ivory buckles for the? N%ext prize";
		String expectedOutput = "wepromptlyjudgedantiqueivorybucklesforthenextprize";

		testPangrams.setInputData(input);

		String output = testPangrams.replaceNonAlphabetChars();

		Assert.assertEquals("Output after replacing is wrong", output, expectedOutput);
	}

	@Test
	public void countingABCLettersWithoutRepetition()
	{
		final int numOfTestABCLetters = 7;

		String input = "abcdefg";

		int count = process(input);

		Assert.assertEquals("The letter counting process has got a wrong result",
				numOfTestABCLetters, count);
	}

	@Test
	public void countingABCLettersWithRepetition()
	{
		final int numOfTestABCLetters = 7;

		String input = "abcdddefffgaa";

		int count = process(input);

		Assert.assertEquals("The letter counting process has got a wrong result",
				numOfTestABCLetters, count);
	}

	@Test
	public void countingABCLettersWithRepetitionAndLimit()
	{
		final int numOfTestABCLetters = 26;

		String input = "We promptly judged antique ivory buckles for the next prize";

		testPangrams.setInputData(input);

		String cleanSentence = testPangrams.replaceNonAlphabetChars();

		int count = process(cleanSentence);

		Assert.assertEquals("The letter counting process has got a wrong result",
				numOfTestABCLetters, count);
	}
}
