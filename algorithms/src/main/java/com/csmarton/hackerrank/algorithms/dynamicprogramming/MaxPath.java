package com.csmarton.hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxPath {
    private int[][] array;
    private int size;

	public static void main(String[] args)
	{
		MaxPath maxPath = new MaxPath();

		maxPath.start();
	}

	private void start()
	{

        createMatrix();

        findMaxRoute();
	}

	private int[] position;


    private void findMaxRoute() {

        int sum = getCurrentValue();
        int upProfit = calculateUp();
        int rightProfit = calculateRight();

        while (!(position[0] == size - 1 && position[1] == 0)) {
            if(position[0] == size - 1) {
                sum += upProfit;

                break;
            }

            if(position[1] == 0) {
                sum += rightProfit;

                break;
            }

            if (upProfit - getLeftValue() >= rightProfit - getHeadValue()) {
                position[1] -= - 1;

                rightProfit = calculateRight();
                upProfit -= getCurrentValue();
            } else {
                position[0] += 1;

                upProfit = calculateUp();
                rightProfit -= getCurrentValue();
            }

            sum += getCurrentValue();
        }
        System.out.println(sum);
    }



    private int calculateUp() {
        int sum = 0;
        for(int i = position[1]; i >= 0; i--) {
            sum += array[position[0]][i];
        }

        return sum;
    }

    private int calculateRight() {
        int sum = 0;
        for(int i = position[0]; i < array[0].length; i++) {
            sum += array[i][position[1]];
        }

        return sum;
    }

    private void createMatrix() {
        String input = "3\n" + "4 0 1\n" + "1 0 0\n" + "0 4 0";

        Scanner in = new Scanner(input);

        size = in.nextInt();

        array = new int[size][size];

        IntStream.range(0, size).forEach(row -> {
            IntStream.range(0, size).forEach(column -> {
                array[column][row] = in.nextInt();
            });
        });

        position = new int[]{0, size - 1};
    }

    public int getLeftValue() {
        if (position[0] == array[0].length - 1) {
            return 0;
        }

        return array[position[0] + 1][position[1]];
    }

    public int getHeadValue() {
        if (position[1] == 0) {
            return 0;
        }

        return array[position[0]][position[1] - 1];
    }

    public int getCurrentValue() {
        return array[position[0]][position[1]];
    }
}
