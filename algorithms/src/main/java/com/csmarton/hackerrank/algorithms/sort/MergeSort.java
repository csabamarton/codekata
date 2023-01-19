package com.csmarton.hackerrank.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    private int[] array;

    public MergeSort() {
        this.array = new int[]{5,3,6,10,23,1,9,4,2,15};
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        mergeSort.start2();
    }

    private void start2() {
        int[] number =  divAndConq(array);

    }

    private int[] divAndConq(int[] nums) {
        if (nums.length == 1)
            return nums;

        int half = nums.length / 2;

        int[] left = divAndConq(Arrays.copyOfRange(nums, 0, half));
        int[] right = divAndConq(Arrays.copyOfRange(nums, half, nums.length));

        int[] sorted = new int[nums.length];

        int index1 = 0, index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(index2 == right.length || index1 != left.length && left[index1] < right[index2]) {
                sorted[i] = left[index1++];
            } else
                sorted[i] = right[index2++];
        }

        return sorted;
    }







    private void start() {
       int[] number =  divideAndConquere(array);
        
    }

    private int[] divideAndConquere(int[] numbers) {
        if(numbers.length == 1) {
            return numbers;
        }

        int half = numbers.length / 2;

        int[] left = Arrays.copyOfRange(numbers, 0, half);
        int[] right = Arrays.copyOfRange(numbers, half, numbers.length);


        left = divideAndConquere(left);

        right = divideAndConquere(right);

        int leftPos = 0;
        int rightPos = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(rightPos == right.length){
                numbers[i] = left[leftPos];
                leftPos++;

                continue;
            }

            if (leftPos == left.length) {
                numbers[i] = right[rightPos];
                rightPos++;

                continue;
            }
            if (left[leftPos] <= right[rightPos]) {
                numbers[i] = left[leftPos];
                leftPos++;
            } else {
                numbers[i] = right[rightPos];
                rightPos++;
            }
        }

        return numbers;
    }
}
