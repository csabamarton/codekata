package com.csmarton.hackerrank.algorithms.basic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;

        Map<Long, List<Integer>> numOfOccurences = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();
            if(numOfOccurences.containsKey(baseNumber)) {
                numOfOccurences.get(baseNumber).add(i);
            } else
                numOfOccurences.put(baseNumber, new ArrayList<>(Arrays.asList(i)));
        }

        Map<Integer, List<Integer>> numMap= new HashMap<>();

        List<Integer> leftIndexes = new ArrayList<>();


        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();

            final int index = i;

            long key = baseNumber / ratio;
            if(!numOfOccurences.containsKey(key)) {
                leftIndexes.add(i);
            } else {
                List<Integer> integers = numOfOccurences.get(key);
                Optional<Integer> any = integers.stream().filter(numIndex -> numIndex < index).findAny();

            }

            List<Integer> ratioedIndexes = new ArrayList<>();
            if (numOfOccurences.containsKey(baseNumber * ratio))
            {
                ratioedIndexes = numOfOccurences.get(baseNumber * ratio);
                ratioedIndexes = ratioedIndexes.stream().filter(num -> num > index).collect(Collectors.toList());
            }

            numMap.put(i, ratioedIndexes);
        }


        List<Integer> sortedKey = numMap.keySet().stream().collect(Collectors.toList());
        Collections.sort(sortedKey);

        List<Integer> routeLenths = new ArrayList<>();
        for(Integer leftIndex: leftIndexes) {
            checkLeaf(leftIndex, routeLenths, numMap, 1);
        }

        System.out.println(routeLenths.size());

        for (Integer routeLength : routeLenths) {
            numOfTriplets += routeLength - 2;
        }

        return numOfTriplets;
    }

    private static void checkLeaf(Integer index, List<Integer> routeLengths, Map<Integer, List<Integer>> numMap, int depth) {
        List<Integer> leafIndexes = numMap.get(index);
        if (leafIndexes.isEmpty()) {
            routeLengths.add(depth);
            return;
        }
        for (Integer leafIndex: leafIndexes) {
            checkLeaf(leafIndex, routeLengths, numMap, depth + 1);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
