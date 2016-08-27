package com.csmarton.hackerrank.algorithms.sort;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InsertionSort2 {
	public static void insertionSortPart2(int[] ar)
	{
		LinkedList<Integer> list = Lists.newLinkedList();
		list.add(ar[0]);

		for (int i = 1; i < ar.length; i++) {
			insertNewElement(ar[i], list);
			printList(list, ar);
		}

	}

	private static void insertNewElement(int newElement, LinkedList<Integer> list)
	{

		Iterator<Integer> iterator = list.iterator();

		boolean foundGreater = false;

		int position = 0;
		while (iterator.hasNext() && !foundGreater) {
			Integer next = iterator.next();
			if (newElement < next) {
				foundGreater = true;
			} else {
				position++;
			}
		}

		list.add(position, newElement);
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner("6\n" + "1 4 3 5 6 2");
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);
	}

	private static void printList(List<Integer> list, int[] ar)
	{
		Stream<Integer> concatStream = Stream.concat(list.stream(),
				IntStream.range(list.size(), ar.length).mapToObj(i -> ar[i]));

		String result = concatStream.map(Object::toString)
				.collect(Collectors.joining(" "));




		System.out.println(result);
	}
	private static void printListInOneLine(List<Integer> list, int[] ar)
	{
		String result = Stream.concat(list.stream(), IntStream.range(list.size(), ar.length)
				.mapToObj(i -> ar[i]))
					.map(Object::toString)
					.collect(Collectors.joining(" "));

		System.out.println(result);
	}
}
