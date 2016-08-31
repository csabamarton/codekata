package com.csmarton.hackerrank.regexp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class FileProcessor extends Thread {

	public static void main(String[] args)
	{

		int nCores = Runtime.getRuntime().availableProcessors();

		for(int i=0; i < nCores; i++) {
			Thread thread = new FileProcessor();
			// You may need to pass in parameters depending on what work you are doing and how you setup your thread.
			thread.start();
		}
	}

	public static ExecutorService newWorkStealingPool() {
		return new ForkJoinPool
				(Runtime.getRuntime().availableProcessors(),
						ForkJoinPool.defaultForkJoinWorkerThreadFactory,
						null, true);
	}
}
