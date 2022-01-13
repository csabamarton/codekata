package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.*;

public class SherlockAndAnagrams {

    public int solution3(String s) {
        int numofAnagrams = 0 ;

        Map<String, Integer> subStringOccurences = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] chars = s.substring(i, j + 1).toCharArray();
                Arrays.sort(chars);
                String sortedSubString = String.valueOf(chars);

                if(subStringOccurences.containsKey(sortedSubString)){
                    subStringOccurences.put(sortedSubString, subStringOccurences.get(sortedSubString) + 1);
                } else {
                    subStringOccurences.put(sortedSubString, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : subStringOccurences.entrySet()) {
            if(entry.getValue() > 1) {
                numofAnagrams = numofAnagrams + (entry.getValue() * (entry.getValue() - 1))/2 ;
            }
        }

        return numofAnagrams;
    }

    public int solution2(String s) {
        int numOfAnagrams = 0;

        int numOfWhileLoop = 0;

        String[] strings = s.split("");

        Map<String, Integer> baseMap = new HashMap<>();
        Map<String, Integer> comparedMap = new HashMap<>();

        List<Integer> matchedStartIndexes = new ArrayList<>();
        int anagramSize = 1;

        String[] split = s.
                substring(0, 0 + anagramSize)
                .split("");
        baseMap.clear();
        for (String letter: split) {
            if(!baseMap.containsKey(letter)){
                baseMap.put(letter, 1);
            } else {
                baseMap.put(letter, baseMap.get(letter) + 1);
            }
        }

        boolean foundedMatch;
        for (int startIndex = 0; startIndex < s.length() - anagramSize; startIndex++) {
            comparedMap.clear();
            baseMap.clear();
            baseMap.put(strings[startIndex], 1);
            comparedMap.putAll(baseMap);

            foundedMatch = true;
            for(anagramSize = 1; anagramSize < s.length() ; anagramSize++) {

                int firstIndexOfComparedString = startIndex + 1;

                if (anagramSize > 1 && !foundedMatch) {
                    break;
                } else {
                    comparedMap.clear();
                    comparedMap.putAll(baseMap);

                    foundedMatch = false;
                    while (firstIndexOfComparedString + anagramSize <= s.length()) {
                        numOfWhileLoop++;

                        String addLetter = strings[firstIndexOfComparedString + anagramSize - 1];
                        String removedLetter = strings[firstIndexOfComparedString - 1];

                        shiftMapToRight(comparedMap, addLetter, removedLetter);

                        if (areEqual(baseMap, comparedMap)) {
                            System.out.println("match! Base: " + s.substring(startIndex, startIndex + anagramSize) + " / " + s.substring(firstIndexOfComparedString, firstIndexOfComparedString + anagramSize));
                            matchedStartIndexes.add(startIndex);
                            numOfAnagrams++;
                            foundedMatch = true;
                        } else {

                        }

                        firstIndexOfComparedString++;
                    }

                }

                if(startIndex + anagramSize < s.length()) {
                    String letter = strings[startIndex + anagramSize];
                    if(!baseMap.containsKey(letter)){
                        baseMap.put(letter, 1);
                    } else {
                        baseMap.put(letter, baseMap.get(letter) + 1);
                    }
                }
            }

            anagramSize = 1;
        }

        System.out.println("Num of While Loop: " + numOfWhileLoop);
        return numOfAnagrams;
    }


    public int solution(String s) {
        int numOfAnagrams = 0;
        int numOfWhileLoop = 0;

        String[] strings = s.split("");

        Map<String, Integer> baseMap = new HashMap<>();
        Map<String, Integer> comparedMap = new HashMap<>();

        List<Integer> matchedStartIndexes = new ArrayList<>();

        for(int anagramSize = 1; anagramSize < s.length() ; anagramSize++) {
            String[] split = s.
                        substring(0, 0 + anagramSize)
                        .split("");
            baseMap.clear();
            for (String letter: split) {
                    if(!baseMap.containsKey(letter)){
                        baseMap.put(letter, 1);
                    } else {
                        baseMap.put(letter, baseMap.get(letter) + 1);
                    }
                }
            for (int startIndex = 0; startIndex < s.length() - anagramSize; startIndex++) {

                int firstIndexOfComparedString = startIndex + 1;

                comparedMap.clear();
                comparedMap.putAll(baseMap);

                if(anagramSize > 1 && !matchedStartIndexes.contains(startIndex)) {
                    continue;
                } else {
                    while (firstIndexOfComparedString + anagramSize <= s.length()) {
                        numOfWhileLoop++;
                        String addLetter = strings[firstIndexOfComparedString + anagramSize - 1];
                        String removedLetter = strings[firstIndexOfComparedString - 1];

                        shiftMapToRight(comparedMap, addLetter, removedLetter);

                        if (areEqual(baseMap, comparedMap)) {
                            matchedStartIndexes.add(startIndex);
                            numOfAnagrams++;
                        }

                        firstIndexOfComparedString++;
                    }
                }

                String addLetter = strings[startIndex + anagramSize];
                String removedLetter = strings[startIndex];
                shiftMapToRight(baseMap, addLetter, removedLetter);
            }

        }

        System.out.println("Num of While Loop: " + numOfWhileLoop);
        return numOfAnagrams;
    }

    private void shiftMapToRight(Map<String, Integer> map, String addLetter, String removedLetter) {
        if(!map.containsKey(addLetter)){
            map.put(addLetter, 1);
        } else {
            map.put(addLetter, map.get(addLetter) + 1);
        }

        if(map.containsKey(removedLetter)) {
            if (map.get(removedLetter) == 1) {
                map.remove(removedLetter);
            } else {
                map.put(removedLetter, map.get(removedLetter) - 1);
            }
        }
    }

    private boolean areEqual(Map<String, Integer> first, Map<String, Integer> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}
