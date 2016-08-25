package com.csmarton.hackerrank.algorithms.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunnyStringTest {

	FunnyString funnyString;

	@Before
	public void setUp() throws Exception
	{
		funnyString = new FunnyString();
		funnyString.setInputDataFromFile("funnyString/input2.txt");
	}

	@Test
	public void testSetInputData() {
		String[] expectedArray = new String[]{"acxz", "bcxz"};
		Assert.assertArrayEquals(expectedArray, funnyString.getWords());
	}

	@Test
	public void testCalculatingDistanceBetweenLettes(){
		char firstLetter = 'a';
		char secondLetter= 'c';

		int actualDistanceBetweenLetters = funnyString
				.getDistanceBetweenLetters(firstLetter, secondLetter);

		int expectedDistance = 2;

		Assert.assertEquals(expectedDistance, actualDistanceBetweenLetters);
	}

	@Test
	public void testSolveFunnyString() {
		Assert.assertTrue(funnyString.solve("acxz"));
	}

	@Test
	public void testSolveNotFunnyString() {
		Assert.assertFalse(funnyString.solve("ivvkx"));
	}
}