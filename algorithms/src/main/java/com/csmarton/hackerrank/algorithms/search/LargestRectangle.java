package com.csmarton.hackerrank.algorithms.search;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class LargestRectangle {

	private TreeMap<Integer, Integer> distances = new TreeMap<>();
	private int[] histograms;
	private int maxRecSize = 0;

	public static void main(String[] args)
	{
		LargestRectangle largestRectangle = new LargestRectangle();
		largestRectangle.loadData();
		largestRectangle.calculateLargestRectangle();
	}

	private void loadData()
	{
		histograms = new int[] { 1, 3, 5, 3, 0, 2, 6, 6, 1, 0, 3, 6 };
	}

	private void calculateLargestRectangle()
	{
		IntStream.range(0, histograms.length).forEach(index -> processColumn(index));

		System.out.println(maxRecSize);
	}


	private void processColumn(int index)
	{
		int height = histograms[index];

		if (distances.size() == 0) {
			distances.put(height, 1);

			if(maxRecSize < height) {
				maxRecSize = height;
			}

			return;
		}

		if(height == 0) {
			distances.clear();
			return;
		}

		int highest = distances.lastKey();

		if (height == highest) {
			increaseAll();
		} else if (height > highest) {
			increaseAll();

			distances.put(height, 1);
		} else {
			int distance = checkSameSizeDistance(height, index);
			deleteBiggers(height);
			increaseAll();

			distances.put(height, distance);
		}

		checkMaxSizes();
	}

	private int checkSameSizeDistance(int height, int index)
	{
		int actualIndex = index;

		boolean hasNext = true;
		while(hasNext && actualIndex > 0) {

			int actualHeight = histograms[actualIndex - 1];

			if(actualHeight < height) {
				break;
			} else {
				actualIndex--;
			}
		}

		return index - actualIndex + 1;
	}

	private void checkMaxSizes()
	{
		for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
			int size = entry.getKey() * entry.getValue();
			if(maxRecSize < size) {
				maxRecSize = size;
			}
		}
	}

	private void deleteBiggers(int height)
	{
		LinkedList<Integer> indexesForRemove = new LinkedList<>();

		for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
			if(entry.getKey() > height) {
				indexesForRemove.add(entry.getKey());
			}
		}

		if(indexesForRemove.size() > 0) {
			for (int i = 0; i < indexesForRemove.size(); i++) {
				distances.remove(indexesForRemove.get(i));
			}
		}
	}

	private void increaseAll() {
		for(Map.Entry<Integer, Integer> entry : distances.entrySet()) {
			entry.setValue(entry.getValue() + 1);
		}
	}
}
