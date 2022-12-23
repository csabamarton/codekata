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
                if(row[horizontal] == 0)
                    continue;

                if(cluster.containsKey(vertical + horizontal + ""))


                if(isIsland(grid, vertical, horizontal))
                    numOfIslands++;
            }
        }

        return numOfIslands;
    }

    private boolean isNextToAnIsland(char[][] grid, int vertical, int horizontal, Map<String, Integer> cluster) {
        if(grid[vertical][horizontal] == 0)
            return false;

        int clusterKey = 0;

        if(vertical > 0 && cluster.containsKey((vertical - 1) + "" +  horizontal) ||
                vertical < grid.length -1 && cluster.containsKey((vertical + 1) + "" +  horizontal) ||
                horizontal > 0 && cluster.containsKey((vertical) + "" +  (horizontal - 1)) ||
                horizontal < grid[vertical].length - 1 && cluster.containsKey((vertical) + "" +  (horizontal + 1)))
            cluster.put(vertical + "" + horizontal, 1)
            if(vertical == grid.length - 1 || grid[vertical + 1][horizontal] == 0)
                if(horizontal == 0 || grid[vertical][horizontal - 1] == 0)
                    if (horizontal == grid[vertical].length - 1 || grid[vertical][horizontal + 1] == 0)
                        return true;
        return false;
    }


    private boolean isIsland(char[][] grid, int vertical, int horizontal) {
        if(grid[vertical][horizontal] == 0)
            return false;
        if(vertical == 0 || grid[vertical - 1][horizontal] == 0)
            if(vertical == grid.length - 1 || grid[vertical + 1][horizontal] == 0)
                if(horizontal == 0 || grid[vertical][horizontal - 1] == 0)
                    if (horizontal == grid[vertical].length - 1 || grid[vertical][horizontal + 1] == 0)
                        return true;
        return false;
    }

}
