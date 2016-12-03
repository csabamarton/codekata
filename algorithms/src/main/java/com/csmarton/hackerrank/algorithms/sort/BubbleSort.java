package com.csmarton.hackerrank.algorithms.sort;

import java.util.stream.IntStream;

public class BubbleSort {

    private int[] numbers;

    public BubbleSort() {
        this.numbers = new int[]{5, 3, 6, 10, 23, 1, 9, 4, 2, 15};
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.start();
    }

    private void start() {

        int end = numbers.length - 1;

        while (end > 1) {
            IntStream.range(0, end).forEach(i -> {
                if (numbers[i] > numbers[i + 1]) {
                    swap(i, i + 1);
                }
            });

            end--;
        }
    }

    private void swap(int index1, int index2) {
        int first = numbers[index1];

        numbers[index1] = numbers[index2];
        numbers[index2] = first;
    }
}
