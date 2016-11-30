package com.csmarton.hackerrank.datastrucure.heap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Qheap {

	private enum HeapQuery {
		ADD(1), REMOVE(2), PRINT_MIN(3);

		private int value;

		HeapQuery(int value)
		{
			this.value = value;
		}

		static HeapQuery getValue(int value)
		{
			for (HeapQuery e : HeapQuery.values()) {
				if (e.value == value) {
					return e;
				}
			}
			return null;
		}
	}

	private int[] heap = new int[10];
	private int position = 0;

	public static void main(String[] args)
	{
		Qheap qheap = new Qheap();

		qheap.start(qheap);
	}

	private void start(Qheap qheap)
	{
		Scanner in = new Scanner(System.in);

		int numOfQueries = in.nextInt();
		in.nextLine();

		IntStream.range(0, numOfQueries).forEach(i -> {
			int typeOfQuery = in.nextInt();

			HeapQuery hq = HeapQuery.getValue(typeOfQuery);

			switch (hq) {
			case ADD:
				qheap.addElement(in.nextInt());
				break;
			case REMOVE:
				qheap.removeElement(in.nextInt());
				break;
			case PRINT_MIN:
				qheap.printMin();
				break;
			}
		});
	}

	private void addElement(int newElement)
	{
		if (position == 0) {
			heap[0] = newElement;
			position++;

			return;
		}

		if (heap.length == position) {
			increaseHeapSize();
		}

		heap[position++] = newElement;

		bubbleUp();
	}

	private void increaseHeapSize()
	{
		int[] newHeap = Arrays.copyOf(heap, heap.length * 2);
		heap = newHeap;
	}

	private void bubbleUp()
	{
		boolean needToLookUp = true;

		int currentIndex = position - 1;

		while (needToLookUp) {
			int currentValue = heap[currentIndex];
			int parentIndex = ((currentIndex + 1) / 2) - 1;
			int parentValue = heap[parentIndex];
			if (parentValue > currentValue) {
				heap[parentIndex] = currentValue;
				heap[currentIndex] = parentValue;

				currentIndex = parentIndex;

				if (currentIndex == 0) {
					needToLookUp = false;
				}
			} else {
				needToLookUp = false;
			}
		}
	}

	private void removeElement(int removingElement)
	{
		int removeIndex = search(0, removingElement);

		if (removeIndex == position - 1) {
			position--;
			heap[removeIndex] = 0;

			return;
		}

		heap[removeIndex] = heap[position - 1];
		heap[position - 1] = 0;
		position--;

		sinkDown(removeIndex);
	}

	private void sinkDown(int from)
	{
		int leftIndex = ((from + 1) * 2) - 1;
		int rightIndex = leftIndex + 1;

		if (leftIndex < position) {
			int compareIndex = leftIndex;
			int leftValue = heap[leftIndex];

			boolean hasTwoChild = rightIndex < position;

			if (hasTwoChild) {
				int rightValue = heap[rightIndex];
				if (rightValue < leftValue) {
					compareIndex = rightIndex;
				}
			}

			int value = heap[from];
			if (heap[compareIndex] < value) {
				heap[from] = heap[compareIndex];
				heap[compareIndex] = value;

				sinkDown(compareIndex);
			}
		}
	}

	private int search(int from, int value)
	{
		int foundedIndex = -1;

		if (heap[from] == value) {
			return from;
		}
		int leftIndex = ((from + 1) * 2) - 1;
		int rightIndex = leftIndex + 1;

		if (leftIndex < position) {
			foundedIndex = search(leftIndex, value);
		}

		if (foundedIndex < 0) {
			if (rightIndex < position) {
				foundedIndex = search(++leftIndex, value);
			}
		}

		return foundedIndex;
	}

	private void printMin()
	{
		System.out.println(heap[0]);
	}
}
