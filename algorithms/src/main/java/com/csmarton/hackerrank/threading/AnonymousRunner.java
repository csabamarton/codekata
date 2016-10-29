package com.csmarton.hackerrank.threading;

import java.util.stream.IntStream;

public class AnonymousRunner
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runnable(){

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
		});

		t1.start();
	}
}
