package com.csmarton.hackerrank.algorithms.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RichieRichTest {
	private static final String TEST_RESOURCE_FOLDER = "src/test/resources/";
	private static final String RICHIE_RICH_RESOURCE_FOLDER = "richierich/";
	private static final String TEST1_INPUT_FILE = "input.txt";

	private RichieRich richieRich;

	@Before
	public void setUp() {
		richieRich = new RichieRich();
	}

	@Test
	public void checkHavingResourceFolderForThis()
	{
		File file = richieRich.getResourceFile(TEST_RESOURCE_FOLDER + RICHIE_RICH_RESOURCE_FOLDER);

		Assert.assertNotNull(file);
	}

	@Test
	public void testLoadingInputDataFromResource() throws FileNotFoundException
	{
		loadInputs();

		assertEquals("Change limit has been loaded wrongly", 1, richieRich.getChangeLimit());
		assertEquals("Input string has been loaded wrongly", "3943", richieRich.getInputNumber());
	}

	private void loadInputs() throws FileNotFoundException
	{
		File file = richieRich.getResourceFile(TEST_RESOURCE_FOLDER + RICHIE_RICH_RESOURCE_FOLDER + TEST1_INPUT_FILE);
		richieRich.getInputString(file);
	}

	@Test
	public void testGetPositionsOfNeedToChange() throws FileNotFoundException
	{
		loadInputs();

		List<Integer> positionsOfNeedToChange = richieRich.getPositionsOfNeedToChange();

		List<Integer> expectedIndexes = new ArrayList<>();
		expectedIndexes.add(1);
		assertEquals("Indexes of Wrong Numbers are wrong", expectedIndexes, positionsOfNeedToChange);
	}
}