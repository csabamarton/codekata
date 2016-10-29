package com.csmarton.hackerrank.threading;

import java.util.stream.IntStream;

class Runner implements Runnable {

	@Override
	public void run()
	{
		IntStream.range(0, 10).forEach(count -> todo(count));
	}

	private void todo(int count)
	{
		System.out.println("Hello " + count);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Practise1 {
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());

		t1.start();
		t2.start();
	}
}
