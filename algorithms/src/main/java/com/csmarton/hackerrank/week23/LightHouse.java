package com.csmarton.hackerrank.week23;

import java.util.*;

public class LightHouse {
	int maxLength = 0;
	int maxLengthRowIndex;
	int numOfRows = 0;

	List<Level> lines = new ArrayList<>();

	Map<Integer, List<Level>> rowLevels = new HashMap<>();

	Map<Integer, List<Level>> lineMapByLength = new HashMap<>();

	public static void main(String[] args)
	{
		LightHouse solution = new LightHouse();

		solution.solve();
	}

	private void solve()
	{

		String input = "9\n"
				+ "*********\n"
				+ "****.****\n"
				+ "**.....**\n"
				+ "**.....**\n"
				+ "*.......*\n"
				+ "**.....**\n"
				+ "**.....**\n"
				+ "****.****\n"
				+ "*********";

			input = "5\n"
					+ ".*.*.\n"
					+ "*...*\n"
					+ ".....\n"
					+ "*...*\n"
					+ ".*.*.";

			input = "5\n"
					+ "***.*\n"
					+ "**..*\n"
					+ "***.*\n"
					+ "*****\n"
					+ "*****";

		Scanner in = new Scanner(input);

		numOfRows = in.nextInt();

		in.nextLine();
		for (int i = 0; i < numOfRows; i++) {
			checkRowAndAddLine(in.nextLine(), i);
		}

		boolean foundPlace = false;

		for (int i = maxLength; i > 1; i--) {
			if (startInvetigate(i)) {
				System.out.println(i / 2);
				foundPlace = true;

				break;
			}
		}

		if (!foundPlace) {
			System.out.println(0);
		}
	}

	private boolean startInvetigate(int length)
	{
		List<Level> levelsOnLength = lineMapByLength.get(length);

		boolean isSublevelsGood;

		if (levelsOnLength != null) {
			for (int i = 0; i < levelsOnLength.size(); i++) {

				Level level = levelsOnLength.get(i);
				int numOfNeededIteration = (length % 2 == 1 ? (length / 2) : ((length - 1) / 2));

				if (numOfNeededIteration == 0) {
					continue;
				}

				if((numOfNeededIteration > level.rowIndex) || (numOfNeededIteration > numOfRows - level.rowIndex + 1)){
					continue;
				}

				int numOfIteration = 0;

				isSublevelsGood = true;

				while (numOfIteration < numOfNeededIteration && isSublevelsGood) {
					isSublevelsGood = checkSubLevels(level, numOfIteration + 1, false);
					isSublevelsGood &= checkSubLevels(level, numOfIteration + 1, true);

					numOfIteration++;
				}

				if (isSublevelsGood) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean checkSubLevels(Level level, int diff, boolean downway)
	{
		int rowIndex = level.rowIndex;

		List<Level> levelsInRow;
		if (!downway)
			levelsInRow = rowLevels.get(rowIndex + diff);
		else {
			levelsInRow = rowLevels.get(rowIndex - diff);
		}

		if (levelsInRow == null) {
			return false;
		}

		for (Level line : levelsInRow) {
			int mustStartIndex = level.startIndex + diff;
			int mustEndIndex = level.endIndex - diff;

			if (line.startIndex <= mustStartIndex && mustEndIndex <= line.endIndex) {
				return true;
			}
		}

		return false;
	}

	private void checkRowAndAddLine(String row, int rowIndex)
	{
		char[] rowSplitted = row.toCharArray();

		boolean buildablePlace = false;

		int startIndex = 0;
		int endIndex;

		for (int i = 0; i < rowSplitted.length; i++) {
			char item = rowSplitted[i];

			if (item == '.' && !buildablePlace) {
				startIndex = i;
				buildablePlace = true;
			}

			if ((item == '*' || i == rowSplitted.length - 1) && buildablePlace) {
				endIndex = i - 1;
				buildablePlace = false;

				Level level = new Level();
				level.startIndex = startIndex;
				level.endIndex = endIndex;
				level.rowIndex = rowIndex;
				int length = endIndex - startIndex + 1;

				level.length = length;

				lines.add(level);

				List<Level> levelsWithLength = lineMapByLength.get(length);

				if (levelsWithLength == null) {
					levelsWithLength = new ArrayList<>();
				}

				levelsWithLength.add(level);

				lineMapByLength.put(length, levelsWithLength);

				List<Level> levelsInRow = rowLevels.get(rowIndex);

				if (levelsInRow == null) {
					levelsInRow = new ArrayList<>();
				}

				rowLevels.put(rowIndex, levelsInRow);

				levelsInRow.add(level);

				if (maxLength < length) {
					maxLength = length;
					maxLengthRowIndex = rowIndex;
				}
			}
		}
	}

	private class Level {
		int startIndex;
		int endIndex;
		int rowIndex;
		int length;
	}
}

