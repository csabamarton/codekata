package com.csmarton.hackerrank.week22;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test
{
	SortedSet<Threshold> mergeThresholds(Collection<Threshold> ranges)
	{
		SortedSet<Threshold> result = new TreeSet<Threshold>(new ThresholdComparator());
		SortedSet<Threshold> sortedSet = new TreeSet<Threshold>(new ThresholdComparator());

		sortedSet.addAll(ranges);

		Threshold prev = null;

		for (Threshold t : sortedSet) {
			if (prev == null) {
				prev = t;

				continue;
			}

			if (prev.canMerge()) {
				prev = prev.merge(t);
			} else {
				result.add(prev);
				prev = null;
			}
		}

		return result;
	}

	class Threshold
	{
		int num;

		boolean canMerge()
		{
			return true;
		}

		Threshold merge(Threshold merged)
		{
			return this;
		}
	}

	public class ThresholdComparator implements Comparator<Threshold>
	{
		@Override
		public int compare(Threshold o1, Threshold o2)
		{
			return o2.num - o1.num;
		}


	}

}

