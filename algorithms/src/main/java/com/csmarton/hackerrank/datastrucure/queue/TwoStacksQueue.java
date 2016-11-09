package com.csmarton.hackerrank.datastrucure.queue;

import java.util.Stack;

public class TwoStacksQueue<T> {

	Stack<T> stackNewOnTop = new Stack<T>();
	Stack<T> stackOldOnTop = new Stack<T>();

	private void enqueue(T newElement) {
		stackNewOnTop.push(newElement);
	}

	private void dequeue() {

	}

	private void print() {

		//flip

		System.out.print(stackOldOnTop.peek());
	}

	public static void main(String[] args)
	{

	}
}
