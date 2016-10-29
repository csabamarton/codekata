package com.csmarton.hackerrank.threading;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run()
	{
		while (running) {
			System.out.println("Running");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class StopItWithAPress
{


	public static void main(String[] args)
	{
		Processor t1 = new Processor();

		t1.start();

		Scanner scanner = new Scanner(System.in);

		scanner.nextLine();

		t1.shutdown();

	}
}
