package com.csmarton.collections;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException {

	private final List<Integer> numbers = new ArrayList<>();;

	public static void main(String[] args)
	{
		ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
		concurrentModificationException.setNumbers();
	}

	protected void setNumbers()
	{
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
	}

	public List<Integer> getNumbers()
	{
		return numbers;
	}
}
