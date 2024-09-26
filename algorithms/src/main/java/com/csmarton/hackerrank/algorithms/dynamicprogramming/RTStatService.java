package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * Calculates the realtime statistic of the last 60 seconds. We don't need to write real code, even
 * pseudo code is fine.
 */
// The name is not fully understandable
public class RTStatService
{
	// Why not use https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html ?
	public static final int ONE_MIN_IN_LONG = 60 * 1000;

	private RealtimeStatistic realtimeStatistic = new RealtimeStatistic();

	// I'd rather go for separate private final ReadLock and private final WriteLock instance variables
	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	public static void main(String[] args)
	{
		RTStatService RTStatService = new RTStatService();

		RTStatService.start();
	}

	// Seems unnecessary, can everything from here be done in static contenxt in main()
	private void start() {
		// Extract method begin
		Transaction transaction = new Transaction();
		transaction.setAmount(100d);
		transaction.setTimestampMs(new Date().getTime());

		addTransaction(transaction);

		System.out.println(realtimeStatistic.getAvg());
		// Extract method end

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// I don't like printing the stack trace
			e.printStackTrace();
		}

		Transaction transaction2 = new Transaction();
		transaction2.setAmount(200d);
		transaction2.setTimestampMs(new Date().getTime());

		addTransaction(transaction2);

		System.out.println(realtimeStatistic.getAvg());
	}

	/**
	 * Returns the realtime statistic of the last 60 seconds. In the best case, this method can be
	 * executed in constant memory and performance. In a good case, this method will execute in
	 * either constant memory or performance. If that's not possible, not having constant memory and
	 * performance is also ok.
	 *
	 * @return The realtime statistic of the last 60 seconds.
	 */
	public RealtimeStatistic getStatisticFromLast60Seconds()
	{
		// Seems unnecessary
		if(lock.isWriteLocked()) {
			System.out.println("will take the lock from Write");
		}
		try {
			// readLock.lock();
			lock.readLock().lock();

			return realtimeStatistic;
		} finally {
			// readLock.unlock();
			lock.readLock().unlock();
		}
	}

	/**
	 * This method will be called everytime a new transaction arrives.
	 *
	 * @param transaction The new transaction.
	 */

	// private
	Deque<Transaction> transactionsInOneMin = new LinkedList<>();

	public void addTransaction(Transaction transaction)
	{
		try {
			// writeLock.lock();
			lock.writeLock().lock();

			transactionsInOneMin.addLast(transaction);

			// Should be instance method of RealtimeStatistics
			if (realtimeStatistic.max == 0d) {
				realtimeStatistic.setMax(transaction.amount);
				realtimeStatistic.setMin(transaction.amount);
				realtimeStatistic.setAvg(transaction.amount);
				realtimeStatistic.setN(1);

				return;
			}

			removeLateTransactionsAndCorrigateStatistics(transaction.getAmount());

		} finally {
			// writeLock.unlock();
			lock.writeLock().unlock();
		}
	}

	private double removeLateTransactionsAndCorrigateStatistics(double amountOfNewTransaction)
	{
		Long timestampMs = new Date().getTime() - ONE_MIN_IN_LONG;

		Iterator<Transaction> iterator = transactionsInOneMin.iterator();

		// Please choose a proper name
		boolean isIn60Seconds = false;
		// removeCount
		int numOfRemovingTransaction = 0;
		// Why necessary? Seems like a premature optimization to calculate the delta instead of 
		// recalculating always the whole remaining transactions 
		double sumOfRemovingTransaction = 0d;
		// Scope is too wide and name is not adequate
		Transaction transaction = null;

		while (iterator.hasNext() && !isIn60Seconds) {
			transaction = iterator.next();

			// I think I wouldn't allow = here
			if (timestampMs <= transaction.getTimestampMs()) {
				isIn60Seconds = true;
			} else {
				// I think I'd recalculate the whole transaction details always instead.
				// Would make the code more readable
				numOfRemovingTransaction++;
				sumOfRemovingTransaction += transaction.getAmount();
			}
			
		}

		// Why not use iterator.remove() inside while loop?
		// If so, I'd extract method
		IntStream.range(0, numOfRemovingTransaction)
				 .forEach(counter -> transactionsInOneMin.removeFirst());

		modifyRealTimeSatisticBases(sumOfRemovingTransaction, numOfRemovingTransaction,
				amountOfNewTransaction);

		return sumOfRemovingTransaction;
	}

	// I'd recalculate always from scratch
	// But if left so, I'd choose a proper name like splitAnd
	private void modifyRealTimeSatisticBases(double sumOfRemovingTransaction,
			int numOfRemovingTransaction, double amountOfNewTransaction)
	{
		// I'd extract to RealtimeStatistics
		realtimeStatistic.setAvg(setNewAvg(sumOfRemovingTransaction, numOfRemovingTransaction, amountOfNewTransaction));

		// I'd extract to RealtimeStatistics
		realtimeStatistic.setN(realtimeStatistic.getN() - numOfRemovingTransaction + 1);

		// I'd extract to RealtimeStatistics
		double newMin = realtimeStatistic.getMin();
		double newMax = realtimeStatistic.getMax();

		for (Transaction transaction : transactionsInOneMin) {
			double amount = transaction.getAmount();
			if (amount > newMax) {
				newMax = amount;
			}
			if (amount < newMin) {
				newMin = amount;
			}
		}

		realtimeStatistic.setMax(newMax);
		realtimeStatistic.setMin(newMin);

	}

	// I'd extract to RealtimeStatistics
	private double setNewAvg(double sumOfRemovingTransaction, int numOfRemovingTransaction,
			double amountOfNewTransaction)
	{
		return (realtimeStatistic.getAvg() * realtimeStatistic.getN() - sumOfRemovingTransaction
				+ amountOfNewTransaction)
				/ (realtimeStatistic.getN() - numOfRemovingTransaction + 1);
	}

	// Why public?
	public static class Transaction
	{
		// Why not long?
		private Long timestampMs;
		private double amount;

		public Long getTimestampMs()
		{
			return timestampMs;
		}

		public void setTimestampMs(Long timestampMs)
		{
			this.timestampMs = timestampMs;
		}

		public double getAmount()
		{
			return amount;
		}

		public void setAmount(double amount)
		{
			this.amount = amount;
		}
	}

	// Why public, and why not RealtimeStatistics?
	public static class RealtimeStatistic
	{
		private double max;
		private double min;
		private double avg;
		// What is n? Please choose a proper name
		private long n;

		public double getMax()
		{
			return max;
		}

		public void setMax(double max)
		{
			this.max = max;
		}

		public double getMin()
		{
			return min;
		}

		public void setMin(double min)
		{
			this.min = min;
		}

		public double getAvg()
		{
			return avg;
		}

		public void setAvg(double avg)
		{
			this.avg = avg;
		}

		public long getN()
		{
			return n;
		}

		public void setN(long n)
		{
			this.n = n;
		}
	}
}
