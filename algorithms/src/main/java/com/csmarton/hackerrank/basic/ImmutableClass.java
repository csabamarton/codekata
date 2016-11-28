package com.csmarton.hackerrank.basic;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClass
{
	public ImmutableClass(int number, HashMap<Integer, String> map)
	{
		HashMap<Integer, String> tempMap = new HashMap<>();
		Integer key;

		Iterator<Integer> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			key = iterator.next();

			tempMap.put(key, map.get(key));
		}

		this.map = tempMap;
		this.number = number;
	}

	private final int number;

	private final HashMap<Integer, String> map;

	public int getNumber()
	{
		return number;
	}

	public HashMap<Integer, String> getMap()
	{
		return (HashMap<Integer, String>) map.clone();
	}
}