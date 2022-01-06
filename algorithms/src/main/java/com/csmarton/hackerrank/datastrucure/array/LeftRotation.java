package com.csmarton.hackerrank.datastrucure.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeftRotation {
    public List<Integer> solution(List<Integer> initialList, int numOfRotation) {
        Queue<Integer> integers = new LinkedList<>(initialList);

        IntStream.rangeClosed(1, numOfRotation).forEach(i -> {
                    integers.add(integers.remove());
                }
        );

        return new ArrayList<>(integers);
    }
}
