package com.csmarton.hackerrank.basics.generics;

import com.google.common.collect.Lists;

import java.util.List;

public class Calculator<T extends Comparable<T>> {
	private T getMax(List<T> list, int begin, int end)
	{
		if (list == null) {
			return null;
		}

		if (list.size() < begin || begin < 0 || end < 0 || begin >= end) {
			return null;
		}

		T max = list.get(begin);

		for (int i = begin; i < end; i++) {
			if (max.compareTo(list.get(i)) < 0) {
				max = list.get(i);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		Calculator<String> stringCalculator = new Calculator<>();

		List<String> strings = Lists.newArrayList("apple", "organge", "pineapple", "banana",
				"cherry");

		String max = stringCalculator.getMax(strings, 1, 4);
		System.out.println(max);
	}
}
