package com.csmarton.hackerrank.algorithms.implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks
{
	private List<Stick> sticks;
	private Cutter cutter;

	public static void main(String[] args)
	{
		String input = "6\n" + "5 4 4 2 2 8";
		Scanner in = new Scanner(input);

		CutTheSticks cutTheSticks = new CutTheSticks();
		cutTheSticks.setSticks(in);

		cutTheSticks.startCutting();
	}

	public CutTheSticks()
	{
		this.cutter = new Cutter();
	}

	private void startCutting()
	{
		while (sticks.size() > 0) {
			System.out.println(sticks.size());
			cutter.processCut();
		}
	}

	public void setSticks(Scanner in)
	{
		int numberOfSticks = in.nextInt();

		sticks = new LinkedList<Stick>();

		for (int i = 0; i < numberOfSticks; i++) {
			sticks.add(new Stick(in.nextInt()));
		}
	}

	class Stick
	{
		private int length;

		public Stick(int length)
		{
			this.length = length;
		}

		public int getLength()
		{
			return length;
		}

		public void cut(Stick cutter)
		{
			length = Math.max(0, length - cutter.getLength());
		}
	}

	class Cutter
	{
		public void processCut()
		{
			Stick smallest = getSmallestStick();

			makeTheCuts(smallest);

		}

		private void makeTheCuts(Stick smallestStick)
		{
			Iterator<Stick> iterator = sticks.iterator();

			while (iterator.hasNext()) {
				Stick stick = iterator.next();
				if (smallestStick.getLength() >= stick.getLength()) {
					iterator.remove();
				} else {
					stick.cut(smallestStick);
				}
			}
		}

		private Stick getSmallestStick()
		{
			Iterator<Stick> iterator = sticks.iterator();

			Stick smallestStick = null;

			while (iterator.hasNext()) {
				Stick stick = iterator.next();
				if (smallestStick == null) {
					smallestStick = stick;
				} else {
					if (smallestStick.getLength() > stick.getLength()) {
						smallestStick = stick;
					}
				}
			}
			return smallestStick;
		}
	}
}
