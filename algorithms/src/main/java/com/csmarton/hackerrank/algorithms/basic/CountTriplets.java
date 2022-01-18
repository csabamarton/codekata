package com.csmarton.hackerrank.algorithms.basic;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    public long solution3(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;


        if(ratio == 1) {
            Map<Long, Integer> numOfChildren = new HashMap<>();
            for (int i = 0; i < numbers.size(); i++) {
                Long baseNumber = ((Number) numbers.get(i)).longValue();
                if (numOfChildren.containsKey(baseNumber)) {
                    numOfChildren.put(baseNumber, numOfChildren.get(baseNumber) + 1);
                } else
                    numOfChildren.put(baseNumber, 1);
            }
            for (Map.Entry<Long, Integer> entry : numOfChildren.entrySet()) {
                int size = entry.getValue();
                if (size < 3)
                    continue;
                if(size < 4) {
                    numOfTriplets++;
                    continue;
                }
                long mainIncr = 4;
                long middleIncr = 3;

                int base = 2;
                for (int i = 0; i < size - 4; i++) {
                    base++;
                    middleIncr += base;
                    mainIncr = mainIncr + middleIncr;
                }
                numOfTriplets += mainIncr;
            }

            return numOfTriplets;
        }

        Map<Long, List<Integer>> numOfOccurences = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();
            if(numOfOccurences.containsKey(baseNumber)) {
                numOfOccurences.get(baseNumber).add(i);
            } else
                numOfOccurences.put(baseNumber, new ArrayList<>(Arrays.asList(i)));
        }
        Map<Long, Integer> leftSkip = new HashMap<>();
        Map<Long, Integer> rightSkip = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();

            if(rightSkip.containsKey(baseNumber) && rightSkip.get(baseNumber) < i)
                continue;
            if(leftSkip.containsKey(baseNumber) && leftSkip.get(baseNumber) > i)
                continue;

            final int index = i;

            long rightCount = 0;
            long leftCount = 0;
            long multiple = baseNumber * ratio;
            if (numOfOccurences.containsKey(multiple))
            {
                rightCount = numOfOccurences.get(multiple).stream().parallel().filter(num -> num > index).count();
            }

            if(baseNumber % ratio == 0) {
                long div = baseNumber / ratio;
                if(div>0) {
                    if (numOfOccurences.containsKey(div)) {
                        leftCount = numOfOccurences.get(div).stream().parallel().filter(num -> num < index).count();
                    }
                }
            }

            if (rightCount != 0 && leftCount != 0) {
                numOfTriplets += rightCount * leftCount;
            } else {
                if(rightCount == 0){
                    if(rightSkip.containsKey(baseNumber)) {
                        if(rightSkip.get(baseNumber) > i)
                            rightSkip.put(baseNumber, i);
                    } else
                        rightSkip.put(baseNumber, i);
                }
                if(leftCount == 0){
                    if(leftSkip.containsKey(baseNumber)) {
                        if(leftSkip.get(baseNumber) < i)
                            leftSkip.put(baseNumber, i);
                    } else
                        leftSkip.put(baseNumber, i);
                }
            }
        }

        return numOfTriplets;
    }


    public long solution2(List<Long> numbers, long ratio) {
        long numOfTriplets = 0;


        if(ratio == 1) {
            Map<Long, Integer> numOfChildren = new HashMap<>();
            for (int i = 0; i < numbers.size(); i++) {
                Long baseNumber = ((Number) numbers.get(i)).longValue();
                if (numOfChildren.containsKey(baseNumber)) {
                    numOfChildren.put(baseNumber, numOfChildren.get(baseNumber) + 1);
                } else
                    numOfChildren.put(baseNumber, 1);
            }
            for (Map.Entry<Long, Integer> entry : numOfChildren.entrySet()) {
                int size = entry.getValue();
                if (size < 3)
                    continue;
                if(size < 4) {
                    numOfTriplets++;
                    continue;
                }
                long mainIncr = 4;
                long middleIncr = 3;

                int base = 2;
                for (int i = 0; i < size - 4; i++) {
                    base++;
                    middleIncr += base;
                    mainIncr = mainIncr + middleIncr;
                }
                numOfTriplets += mainIncr;
            }

            return numOfTriplets;
        }

        Map<Long, List<Integer>> numOfOccurences = new HashMap<>();
        Map<Integer, Integer> numOfChild = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();
            if(numOfOccurences.containsKey(baseNumber)) {
                numOfOccurences.get(baseNumber).add(i);
            } else
                numOfOccurences.put(baseNumber, new ArrayList<>(Arrays.asList(i)));
        }

        Map<Integer, List<Integer>> numMap= new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            Long baseNumber = ((Number) numbers.get(i)).longValue();

            final int index = i;

            List<Integer> ratioedIndexes = new ArrayList<>();

            if (numOfOccurences.containsKey(baseNumber * ratio))
            {
                ratioedIndexes = numOfOccurences.get(baseNumber * ratio);
                ratioedIndexes = ratioedIndexes.stream().filter(num -> num > index).collect(toList());
            }

            if(!ratioedIndexes.isEmpty())
                numMap.put(i, ratioedIndexes);

            numOfChild.put(i, ratioedIndexes.size());
        }

       for(Map.Entry<Integer, List<Integer>> entry : numMap.entrySet()){
            List<Integer> secondNode = entry.getValue();

            long count = secondNode.stream().parallel().filter(key -> numOfChild.get(key) > 0).map(key -> numOfChild.get(key)).mapToInt(Integer::valueOf).sum();

            numOfTriplets += count;
        }

        return numOfTriplets;
    }


    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> rightMap = getOccurenceMap(arr);
        Map<Long, Long> leftMap = new HashMap<>();
        long numberOfGeometricPairs = 0;

        for (Number val : arr) {
            long countLeft = 0;
            long countRight = 0;
            long lhs = 0;
            long longVal = val.longValue();
            long rhs = longVal * r;
            if (longVal % r == 0) {
                lhs = longVal / r;
            }
            Long occurence = rightMap.get(val);
            if (occurence != null)
                rightMap.put(longVal, occurence - 1L);

            if (rightMap.containsKey(rhs)) {
                countRight = rightMap.get(rhs);
            }
            if (leftMap.containsKey(lhs)) {
                countLeft = leftMap.get(lhs);
            }
            numberOfGeometricPairs += countLeft * countRight;
            insertIntoMap(leftMap, longVal);
        }
        return numberOfGeometricPairs;
    }

    private static Map<Long, Long> getOccurenceMap(List<Long> test) {
        Map<Long, Long> occurenceMap = new HashMap<>();
        for (Number val : test) {
            insertIntoMap(occurenceMap, val.longValue());
        }
        return occurenceMap;
    }

    private static void insertIntoMap(Map<Long, Long> occurenceMap, Long val) {
        if (!occurenceMap.containsKey(val)) {
            occurenceMap.put(val, 1L);
        } else {
            Long occurence = occurenceMap.get(val);
            occurenceMap.put(val, occurence + 1L);
        }
    }
}
