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
public class RTStatService
{
	public static final int ONE_MIN_IN_LONG = 60 * 1000;

	private RealtimeStatistic realtimeStatistic = new RealtimeStatistic();

	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	public static void main(String[] args)
	{
		RTStatService RTStatService = new RTStatService();

		RTStatService.start();
	}

	private void start() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100d);
		transaction.setTimestampMs(new Date().getTime());

		addTransaction(transaction);

		System.out.println(realtimeStatistic.getAvg());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
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

		if(lock.isWriteLocked()) {
			System.out.println("will take the lock from Write");
		}
		try {
			lock.readLock().lock();

			return realtimeStatistic;
		} finally {
			lock.readLock().unlock();
		}
	}

	/**
	 * This method will be called everytime a new transaction arrives.
	 *
	 * @param transaction The new transaction.
	 */

	Deque<Transaction> transactionsInOneMin = new LinkedList<>();

	public void addTransaction(Transaction transaction)
	{
		try {
			lock.writeLock().lock();

			transactionsInOneMin.addLast(transaction);

			if (realtimeStatistic.max == 0d) {
				realtimeStatistic.setMax(transaction.amount);
				realtimeStatistic.setMin(transaction.amount);
				realtimeStatistic.setAvg(transaction.amount);
				realtimeStatistic.setN(1);

				return;
			}

			removeLateTransactionsAndCorrigateStatistics(transaction.getAmount());

		} finally {
			lock.writeLock().unlock();
		}
	}

	private double removeLateTransactionsAndCorrigateStatistics(double amountOfNewTransaction)
	{
		Long timestampMs = new Date().getTime() - ONE_MIN_IN_LONG;

		Iterator<Transaction> iterator = transactionsInOneMin.iterator();

		boolean isIn60Seconds = false;
		int numOfRemovingTransaction = 0;
		double sumOfRemovingTransaction = 0d;
		Transaction transaction = null;

		while (iterator.hasNext() && !isIn60Seconds) {
			transaction = iterator.next();

			if (timestampMs <= transaction.getTimestampMs()) {
				isIn60Seconds = true;
			} else {
				numOfRemovingTransaction++;
				sumOfRemovingTransaction += transaction.getAmount();
			}
		}

		IntStream.range(0, numOfRemovingTransaction)
				 .forEach(counter -> transactionsInOneMin.removeFirst());

		modifyRealTimeSatisticBases(sumOfRemovingTransaction, numOfRemovingTransaction,
				amountOfNewTransaction);

		return sumOfRemovingTransaction;
	}

	private void modifyRealTimeSatisticBases(double sumOfRemovingTransaction,
			int numOfRemovingTransaction, double amountOfNewTransaction)
	{
		realtimeStatistic.setAvg(setNewAvg(sumOfRemovingTransaction, numOfRemovingTransaction, amountOfNewTransaction));

		realtimeStatistic.setN(realtimeStatistic.getN() - numOfRemovingTransaction + 1);

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

	private double setNewAvg(double sumOfRemovingTransaction, int numOfRemovingTransaction,
			double amountOfNewTransaction)
	{
		return (realtimeStatistic.getAvg() * realtimeStatistic.getN() - sumOfRemovingTransaction
				+ amountOfNewTransaction)
				/ (realtimeStatistic.getN() - numOfRemovingTransaction + 1);
	}

	public static class Transaction
	{
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

	public static class RealtimeStatistic
	{
		private double max;
		private double min;
		private double avg;
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
