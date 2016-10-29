package com.csmarton.hackerrank.datastrucure.queue;

import java.util.NoSuchElementException;

public class MyQueue {

	private static class QueueNode {
		int data;
		QueueNode next;
	}

	public void remove()
	{
		if(firstNode == null) throw new NoSuchElementException();

		if(firstNode == lastNode) {
			firstNode = null;
			lastNode = null;

			return;
		}

		firstNode = firstNode.next;
	}

	public QueueNode peek()
	{
		if(firstNode == null) throw new NoSuchElementException();

		return firstNode;
	}

	public void add(int data)
	{
		QueueNode newNode = new QueueNode();
		newNode.data = data;

		if(firstNode == null) {
			firstNode = newNode;
			lastNode = newNode;

			return;
		}

		lastNode.next = newNode;
		lastNode = newNode;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	private QueueNode lastNode;
	private QueueNode firstNode;

	public static void main(String[] args)
	{
		MyQueue myQueue = new MyQueue();

		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);

		//1
		System.out.println(myQueue.peek().data);

		myQueue.remove();

		//2
		System.out.println(myQueue.peek().data);

		myQueue.remove();

		//3
		System.out.println(myQueue.peek().data);

		//Fasle
		System.out.println(myQueue.isEmpty());

		myQueue.remove();

		//TRUE
		System.out.println(myQueue.isEmpty());

		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);

		//1
		System.out.println(myQueue.peek().data);

		myQueue.remove();

		//2
		System.out.println(myQueue.peek().data);


	}
}
