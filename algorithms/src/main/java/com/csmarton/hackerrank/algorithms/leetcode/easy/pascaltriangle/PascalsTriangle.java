package com.csmarton.hackerrank.algorithms.leetcode.easy.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                int leftValue = j > 0 ? previousRow.get(j - 1) : 0;
                int rightValue = j < i ? previousRow.get(j) : 0;

                currentRow.add(leftValue + rightValue);
            }
            triangle.add(currentRow);
        }

        return triangle;
    }
}
