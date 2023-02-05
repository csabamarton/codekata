package com.csmarton.hackerrank.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RouteFinder {
    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> conns = new ArrayList<>();
        for (int[] arr : connections) {
            List<Integer> row = Arrays.stream(arr).boxed().toList();
            conns.add(row);
        }


        List<Integer> sources = new ArrayList<>();
        int numOfChanges = 0;

        sources.add(0);

        Iterator<List<Integer>> iterator;
        while (!conns.isEmpty()) {

            iterator = conns.iterator();

            while (iterator.hasNext()) {
                List<Integer> next = iterator.next();
                int first = next.get(0);
                int second = next.get(1);

                if (sources.contains(first)) {
                    sources.add(second);
                    numOfChanges++;
                    iterator.remove();
                    continue;
                    //right direction so just
                    // 1. give the second to the sources
                    // 2. remove

                }
                if (sources.contains(second)) {
                    sources.add(first);
                    iterator.remove();

                    continue;
                }
            }
        }

        return numOfChanges;

    }

    public static void main(String[] args) {
        RouteFinder routeFinder = new RouteFinder();

        routeFinder.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}});
    }

}

