package com.csmarton.hackerrank.threading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Invoke
{
	public static void main(String[] args)
	{
		Invoke invoke = new Invoke();

		//invoke.invokeAll();

		invoke.invokeAny();
	}

	Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}

	private void invokeAny() {
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));

		String result = null;
		try {
			result = executor.invokeAny(callables);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);

	}

	private void invokeAll()
	{ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");

		try {
			executor.invokeAll(callables)
					.stream()
					.map(future -> {
						try {
							return future.get();
						}
						catch (Exception e) {
							throw new IllegalStateException(e);
						}
					})
					.forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
