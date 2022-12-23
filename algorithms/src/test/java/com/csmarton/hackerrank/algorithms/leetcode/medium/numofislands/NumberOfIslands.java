package com.csmarton.hackerrank.algorithms.leetcode.medium.numofislands;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 */

import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        Map<String, Integer> cluster = new HashMap<>();

        for (int vertical = 0; vertical < grid.length; vertical++) {
            char[] row = grid[vertical];
            for (int horizontal = 0; horizontal < row.length; horizontal++) {
              if(grid[vertical][horizontal] == '1'){
                  numOfIslands++;
                  walk(grid, vertical, horizontal);
              }
            }
        }

        return numOfIslands;
    }

    private void walk(char[][] grid, int vertical, int horizontal) {
        if (vertical < 0 || horizontal < 0 || vertical >= grid.length ||
                horizontal >= grid[0].length || grid[vertical][horizontal] == '0')
            return;

        grid[vertical][horizontal] = '0';
        walk(grid, vertical - 1, horizontal);
        walk(grid, vertical + 1, horizontal);
        walk(grid, vertical, horizontal + 1);
        walk(grid, vertical, horizontal - 1);
    }

}
