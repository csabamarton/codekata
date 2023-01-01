package com.csmarton.hackerrank.algorithms.leetcode.easy.graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visitedNodes = new boolean[image.length][image[0].length];
        walk(image, visitedNodes, sr, sc, color, image[sr][sc]);

        return image;
    }

    private void walk(int[][] image, boolean[][] visitedNodes, int sr, int sc, int newColor, int baseColor) {
        if(sr == image.length || sr == -1 || sc == image[0].length || sc == -1)
            return;
        if (visitedNodes[sr][sc])
            return;

        if (image[sr][sc] !=  baseColor) {
            visitedNodes[sr][sc] = true;
            return;
        } else {
            visitedNodes[sr][sc] = true;
            image[sr][sc] = newColor;

            walk(image, visitedNodes, sr + 1, sc, newColor, baseColor);
            walk(image, visitedNodes, sr - 1, sc, newColor, baseColor);
            walk(image, visitedNodes, sr, sc + 1, newColor, baseColor);
            walk(image, visitedNodes, sr, sc - 1, newColor, baseColor);
        }
    }
}
