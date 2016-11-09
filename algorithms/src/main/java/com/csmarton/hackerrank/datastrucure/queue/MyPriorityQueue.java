package com.csmarton.hackerrank.datastrucure.queue;

import java.util.PriorityQueue;
import java.util.Random;

public class MyPriorityQueue
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> numbers = new PriorityQueue<>();

		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			int nextInt = rand.nextInt(100);
			System.out.println(nextInt);
			numbers.add(nextInt);
		}

		System.out.println("----------");
		for (int i = 0; i < 10; i++) {
			System.out.println(numbers.poll());
		}
	}
}
