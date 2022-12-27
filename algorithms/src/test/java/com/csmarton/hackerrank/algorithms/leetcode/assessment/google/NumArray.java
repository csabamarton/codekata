package com.csmarton.hackerrank.algorithms.leetcode.assessment.google;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.
 */
public class NumArray {

    private final int[] nums;
    private int[] sums;
    private int sumLength;

    public NumArray(int[] nums) {

        int len = nums.length;
        double s = Math.sqrt(len);

        double sumLength = Math.floor(s);
        this.sumLength = (int) sumLength;

        sums = new int[(int)Math.ceil(len / sumLength)];

        int tempSum = 0;
        int sumsIndex = 0;
        for (int i = 0; i < len; i++) {
            tempSum = tempSum + nums[i];
            if((i + 1) % sumLength == 0) {
                sums[sumsIndex++] = tempSum;
                tempSum = 0;
            }
        }

        if(tempSum > 0)
            sums[sumsIndex] = tempSum;

        this.nums = nums;
    }

    public void update(int index, int val) {
       int diff = val - nums[index];
       nums[index] = val;

        int sumIndex = (int)Math.floor(index / sumLength);

        sums[sumIndex] += diff;
        System.out.println();
    }

    public int sumRange(int left, int right) {
        int leftSumIndex = (int)Math.floor(left / sumLength);
        int rightSumIndex = (int)Math.floor(right / sumLength);

        int totalSum = 0;
        if (leftSumIndex == rightSumIndex) {
            for (int i = left; i <= right; i++) {
                totalSum += nums[i];
            }

            return totalSum;
        }

        if (rightSumIndex - leftSumIndex > 1) {
            for (int i = leftSumIndex + 1; i < rightSumIndex; i++) {
                totalSum += sums[i];
            }
        }

        //left
        int numOfIteration = sumLength - left % sumLength;
        for (int i = left; i < left + numOfIteration; i++) {
            totalSum += nums[i];
        }

        //right
        numOfIteration = right % sumLength;
        for (int i = right - numOfIteration; i <= right; i++) {
            totalSum += nums[i];
        }

        return totalSum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8

        numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        //System.out.println(numArray.sumRange(0,2));

        numArray.sumRange(2, 6);
        numArray.update(4, 8);
        numArray.update(0, 3);
        numArray.update(9, 13);
    }

}
