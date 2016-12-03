package com.csmarton.hackerrank.algorithms.sort;

public class QuickSort {

	private int[] numbers;

	public QuickSort()
	{
		this.numbers = new int[] { 5, 3, 6, 10, 23, 1, 9, 4, 2, 8 };
	}

	public static void main(String[] args)
	{
		QuickSort quickSort = new QuickSort();

		quickSort.start();
	}

	private void start()
	{
		sort(0, numbers.length - 1);
		System.out.println("");
	}

	private void sort(int from, int to)
	{
		if (from == to) {
			return;
		}

		int pivot = numbers[to];
		int wall = from;

		for (int i = from; i < to; i++) {
			if (numbers[i] < pivot) {
				if (wall < i) {
					int temp = numbers[wall];
					numbers[wall] = numbers[i];
					numbers[i] = temp;
				}

				wall++;

			}
		}

		if (wall != to) {
			numbers[to] = numbers[wall];
			numbers[wall] = pivot;
		}

		sort(from, wall - 1);
		sort(wall, to);
	}
}
