package com.csmarton.hackerrank.threading.practice;

public class App {

	private int count = 0;

	public synchronized void incrementCounter()
	{
		count++;
	}

	public static void main(String[] args)
	{
		App app = new App();

		app.doWork();
	}

	private void doWork()
	{
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				incrementCounter();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				incrementCounter();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is: " + count);

	}
}
