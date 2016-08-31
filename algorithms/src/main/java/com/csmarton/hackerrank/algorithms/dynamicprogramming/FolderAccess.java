package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class FolderAccess {

	private List<TreeItem> allItems;

	public List<String> readables;
	public List<String> writables;

	public TreeItem rootNode;

	public static void main(String[] args) throws FileNotFoundException
	{
		FolderAccess folderAccess = new FolderAccess();

		folderAccess.buildFromInputFile("folderaccess/input.txt");
	}

	private void buildFromInputFile(String path) throws FileNotFoundException
	{
		URL resource = this.getClass().getClassLoader().getResource(path);

		buildFromInputFile(new File(resource.getFile()));
	}

	protected void buildFromInputFile(File file) throws FileNotFoundException
	{
		Scanner in = new Scanner(file);

		readables = Lists.newArrayList(in.nextLine().split(" "));
		writables = Lists.newArrayList(in.nextLine().split(" "));

		allItems = Lists.newArrayList();

		while (in.hasNextLine()) {
			String[] edges = in.nextLine().split(" ");

			String parentName = edges[0];

			TreeItem item = getItem(parentName);
			if (item == null) {
				item = new TreeItem(parentName);
				allItems.add(item);
			}

			for (int j = 1; j < edges.length; j++) {
				String childName = edges[j];
				TreeItem child = getItem(childName);
				if (child == null) {
					child = new TreeItem(childName);
					allItems.add(child);
				}

				item.addChild(child);
			}
		}

		rootNode = getItem("1");
	}

	protected void cutNonImportantParts()
	{
		if (!findWritableChildren(rootNode) && !writables.contains(rootNode.getName())) {
			rootNode = null;
		}
	}

	protected boolean findWritableChildren(TreeItem item)
	{
		String name = item.getName();

		boolean mustKeep = false;

		boolean readable = readables.contains(name);
		boolean writable = writables.contains(name);

		if (!(readable || writable)) {
			return false;
		} else if (item.getChildren() == null) {
			return writable;
		} else if (item.getChildren() != null && (readable || writable)) {

			if (writable) {
				mustKeep = true;
			}

			List<TreeItem> children = item.getChildren();

			boolean hasWritableUnderIt;

			for (Iterator<TreeItem> iterator = children.iterator(); iterator.hasNext();) {
				TreeItem child = iterator.next();

				hasWritableUnderIt = findWritableChildren(child);

				if (!hasWritableUnderIt) {
					iterator.remove();
				}

				if (!mustKeep && hasWritableUnderIt) {
					mustKeep = true;
				}
			}
		}

		return mustKeep;
	}

	private TreeItem getItem(String node1)
	{
		for (TreeItem item : allItems) {
			if (item.getName().equals(node1)) {
				return item;
			}
		}

		return null;
	}

	public static class TreeItem {
		private String name;
		private List<TreeItem> children;

		public TreeItem(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return name;
		}

		public void addChild(String name)
		{
			if (getChildren() == null) {
				setChildren(Lists.newArrayList());
			}

			boolean alreadyHasNodeWithThisName = false;
			for (TreeItem item : getChildren()) {
				if (item.getName().equals(name)) {
					alreadyHasNodeWithThisName = true;

					break;
				}
			}

			assertTrue(!alreadyHasNodeWithThisName);

			getChildren().add(new TreeItem(name));
		}

		public TreeItem getNodeByName(String name)
		{
			if (getChildren() == null) {
				return null;
			}

			for (TreeItem item : getChildren()) {
				if (item.getName().equals(name)) {

					return item;
				}
			}
			return null;
		}

		public void addChild(TreeItem child)
		{
			if (getChildren() == null) {
				setChildren(Lists.newArrayList());
			}

			getChildren().add(child);
		}

		public List<TreeItem> getChildren()
		{
			return children;
		}

		public void setChildren(List<TreeItem> children)
		{
			this.children = children;
		}

		@Override
		public int hashCode()
		{
			int result = 0;
			if (children != null && children.size()>0) {
				result += children.hashCode();
			}

			return 39 * result + name.hashCode();
		}
	}
}
