package com.csmarton.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionTest {

	private ConcurrentModificationException concurrentModificationException;

	@Before
	public void setUp() throws Exception
	{
		concurrentModificationException = new ConcurrentModificationException();
		concurrentModificationException.setNumbers();
	}

	@Test(expected = java.util.ConcurrentModificationException.class)
	public void throwConcurrentModificationExceptionWhenModifyingListDuringTheIteration()
	{
		List<Integer> numbers = concurrentModificationException.getNumbers();

		for (Integer number : numbers) {
			if (number.equals(3)) {
				numbers.remove(number);
			}
		}
	}

	@Test
	public void removingElementWithIterator() {
		List<Integer> numbers = concurrentModificationException.getNumbers();

		for(Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			Integer number = iterator.next();

			if(number.equals(3)){
				iterator.remove();
			}
		}
	}
}