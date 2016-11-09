package com.csmarton.hackerrank.datastrucure.heap;

public class MyHeap
{
	int[] array;

	int size;
	int position;

	public MyHeap(int length)
	{
		array = new int[length + 1];
		this.size = length;
		position = 0;
	}

	public static void main(String[] args)
	{
		int[] unsortedInts = {3,2,1,7,8,4,10,16,12};

		MyHeap myHeap = new MyHeap(unsortedInts.length);

		myHeap.createHeap(unsortedInts);

		myHeap.display();

		myHeap.extractAllMin();
	}

	private void extractAllMin() {
		for(int i=1;i<size;i++){
			System.out.println(extractMin());

			display();
		}

		System.out.println("");
	}

	private void display() {
		for(int i=1;i<array.length;i++){
			System.out.print(" " + array[i]);
		}
		System.out.println("");
	}

	private void createHeap(int[] unsortedInts) {
		for (int i = 0; i < unsortedInts.length; i++) {
			insert(unsortedInts[i]);
		}
	}

	private int extractMin() {
		int min = array[1];

		array[1] = array[position -1];
		array[position -1] = 0;
		position--;

		sinkDown();

		return min;
	}

	private void sinkDown() {
		boolean needToCheckDown = true;

		int parentPosition = 1;
		int parentElement = array[1];


		while (needToCheckDown) {

			if(parentPosition * 2 > position - 2) {
				needToCheckDown = false;
				break;
			}

			int rightChildIndex = parentPosition * 2;
			int leftChildIndex = parentPosition * 2 + 1;

			boolean needRightSwap = false;
			boolean needLeftSwap = false;

			int rightChild = array[rightChildIndex];
			int leftChild = array[leftChildIndex];

			if(rightChild < parentElement) {
				needRightSwap = true;
			}

			if(leftChildIndex < position && leftChild < parentElement) {
				needLeftSwap = true;
			}

			if(!needLeftSwap && !needRightSwap) {
				break;
			}


			if(needLeftSwap && needRightSwap) {
				if(rightChild < leftChild) {
					swap(parentElement, parentPosition, rightChild, rightChildIndex);
					parentPosition = rightChildIndex;
				} else {
					swap(parentElement, parentPosition, leftChild, leftChildIndex);
					parentPosition = leftChildIndex;
				}

				continue;
			}

			if(needLeftSwap) {
				swap(parentElement, parentPosition, leftChild, leftChildIndex);
				parentPosition = leftChildIndex;

				continue;
			}

			if(needRightSwap) {
				swap(parentElement, parentPosition, rightChild, rightChildIndex);
				parentPosition = rightChildIndex;

				continue;
			}
		}
	}

	private void swap(int parentElement, int parentPosition, int child, int childIndex) {
		array[parentPosition] = child;
		array[childIndex] = parentElement;
	}

	private void insert(int newElement) {
		if(position == 0){
			position = 2;
			array[1] = newElement;
		} else {
			array[position] = newElement;
			bubbleUp();
			position++;
		}
	}

	private void bubbleUp() {

		int bottomElement = array[position];
		int parent;

		int actualIndex = position;
		int actualElement = bottomElement;

		boolean needToCheckUpper = true;
		while (needToCheckUpper) {
			int parentIndex = actualIndex/2;
			parent = array[parentIndex];

			if(parent > actualElement) {
				array[actualIndex] = parent;
				array[parentIndex] = actualElement;
			} else {
				needToCheckUpper = false;
			}


			if(needToCheckUpper && parentIndex != 1) {
				actualIndex = parentIndex;
			} else {
				needToCheckUpper = false;
			}
		}
	}
}
