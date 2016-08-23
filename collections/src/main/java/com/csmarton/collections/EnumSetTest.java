package com.csmarton.collections;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetTest {
	private enum Color {
		RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
		private final int r;
		private final int g;
		private final int b;

		Color(int r, int g, int b)
		{
			this.r = r;
			this.g = g;
			this.b = b;
		}

		public int getR()
		{
			return r;
		}

		public int getG()
		{
			return g;
		}

		public int getB()
		{
			return b;
		}
	}

	public static void main(String args[])
	{
		EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
		drawLine(yellow);

		EnumSet<Color> white = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
		drawLine(white);

		EnumSet<Color> pink = EnumSet.of(Color.RED, Color.BLUE);
		drawLine(pink);
	}

	public static void drawLine(Set<Color> colors)
	{
		System.out.println("Requested Colors to draw lines : " + colors);

		colors.forEach(color -> System.out.println("drawing line in color : " + color));
	}
}
