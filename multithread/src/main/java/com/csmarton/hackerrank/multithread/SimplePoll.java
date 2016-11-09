package com.csmarton.hackerrank.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SimplePoll
{
	private final ScheduledExecutorService fScheduler;

	public static void main(String[] args)
	{
		SimplePoll simplePoll = new SimplePoll();
		simplePoll.start();
	}

	public SimplePoll()
	{
		this.fScheduler = Executors.newScheduledThreadPool(1);

	}

	private void start() {}
}
