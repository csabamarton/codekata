package com.csmarton.hackerrank.multithread;

public class BoundedQueue<T> {

	private int limit;
	private int size;
	private Object[] array;
	private int headIndex;
	private int tailIndex;


	public BoundedQueue(int limit)
	{
		this.limit = limit;
		this.array = new Object[limit];
		this.size = 0;
	}


	public synchronized void enqueue(Object data) throws InterruptedException
	{
		while (size == limit) {
			wait();
		}

		if (size == 0) {
			array[limit - 1] = data;

			headIndex = limit - 1;
			tailIndex = limit - 1;
			size++;

			return;
		}

		int newIndex;

		if (tailIndex == 0) {
			newIndex = limit - 1;
		} else {
			newIndex = tailIndex - 1;
		}

		tailIndex = newIndex;
		array[tailIndex] = data;
		size++;

		if (size == 0) {
			notifyAll();
		}
	}

	public synchronized T dequeue() throws InterruptedException
	{
		while (size == 0) {
			wait();
		}

		Object returnValue = array[headIndex];

		array[headIndex] = null;

		if (size == 1) {
			size--;
			headIndex = -1;
			tailIndex = -1;

			return (T) returnValue;
		}

		array[headIndex] = null;
		size--;

		if (headIndex == 0) {
			headIndex = limit - 1;
		} else {
			headIndex = headIndex - 1;
		}

		if (size == limit) {
			notifyAll();
		}

        return (T) returnValue;
	}

	public static void main(String[] args) throws InterruptedException
	{
		BoundedQueue<Integer> bq = new BoundedQueue<>(4);

		bq.enqueue(1);
		bq.enqueue(2);
		bq.enqueue(3);
		bq.dequeue();
		bq.enqueue(4);
		bq.enqueue(5);
		bq.dequeue();
		bq.dequeue();
	}
}
