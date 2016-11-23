package com.csmarton.hackerrank.threading;

import java.util.concurrent.*;

public class MyExecutor
{
	private ExecutorService executor;

	public static void main(String[] args)
	{
		MyExecutor myExecutor = new MyExecutor();

		myExecutor.start();
	}

	class MyThread implements Callable<Integer> {

		@Override
		public Integer call() throws Exception
		{
			System.out.println("Waiting 4 sec");
			Thread.sleep(4000);
			return 123;
		}
	}

	private void start() {
		executor = Executors.newSingleThreadExecutor();

		Future<Integer> future = executor.submit(new MyThread());

		try {
			Integer result = future.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		finishExecutor();
	}

	private void finishExecutor() {
		try {
			executor.shutdown();
			executor.awaitTermination(30L, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
