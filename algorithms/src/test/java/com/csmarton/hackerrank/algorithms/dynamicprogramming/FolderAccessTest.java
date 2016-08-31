package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FolderAccessTest {

	private FolderAccess folderAccess;
	private FolderAccess folderAccessForResult;

	@Before
	public void setUp() throws Exception
	{
		folderAccess = new FolderAccess();
		folderAccessForResult = new FolderAccess();
	}

	@Test
	public void mustGetANullTreeItemWhenHavingANonReadAbleAndWritableRoot()
			throws FileNotFoundException
	{
		folderAccess.buildFromInputFile(getInputFile("folderaccess/input1.txt"));

		FolderAccess.TreeItem rootNode = folderAccess.rootNode;
		folderAccess.cutNonImportantParts();

		folderAccessForResult.buildFromInputFile(getInputFile("folderaccess/result1.txt"));

		FolderAccess.TreeItem expectedRootNode = folderAccessForResult.rootNode;

		int expected = expectedRootNode.hashCode();
		int actual = rootNode.hashCode();

		assertEquals(expected, actual);
	}

	private File getInputFile(String path) throws FileNotFoundException
	{
		URL resource = this.getClass().getClassLoader().getResource(path);

		return new File(resource.getFile());
	}

	private void buildTestFolderStructure()
	{
		FolderAccess.TreeItem rootNode = folderAccess.rootNode;

		rootNode = new FolderAccess.TreeItem("1");

		rootNode.addChild("2");
		rootNode.addChild("3");
		rootNode.addChild("4");


		FolderAccess.TreeItem item = rootNode.getNodeByName("2");

		item.addChild("5");
		item.addChild("6");

		item = rootNode.getNodeByName("3");

		item.addChild("7");
		item.addChild("8");

		item = rootNode.getNodeByName("4");
		item.addChild("9");

		folderAccess.readables = Lists.newArrayList("1", "4");
		folderAccess.writables = Lists.newArrayList("2", "5", "9");
	}

}