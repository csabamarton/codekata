package com.csmarton.hackerrank.threading.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	public static void main(String[] args)
	{
		Worker worker = new Worker();

		worker.start();
	}

	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();

	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void stageOne()
	{
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}
	}

	public void process()
	{
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void stageTwo()
	{
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}
	}

	private void start()
	{

		Thread t1 = new Thread(() -> process());
		Thread t2 = new Thread(() -> process());

		long start = System.currentTimeMillis();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time take: " + (end - start));
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}
}
