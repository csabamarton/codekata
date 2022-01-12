package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndAnagrams {

    public int solution(String s) {
        int numOfAnagrams = 0;

        String[] strings = s.split("");

        Map<String, Integer> baseMap = new HashMap<>();

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

                if(anagramSize > 1 && !matchedStartIndexes.contains(startIndex)) {
                    continue;
                }

                int firstIndexOfComparedString = startIndex + 1;

                Map<String, Integer> comparedMap = new HashMap<>();
                comparedMap.putAll(baseMap);

                while (firstIndexOfComparedString + anagramSize <= s.length()) {
                    String addLetter = strings[firstIndexOfComparedString + anagramSize - 1];
                    String removedLetter = strings[firstIndexOfComparedString - 1];

                    shiftMapToRight(comparedMap, addLetter, removedLetter);

                    if(areEqual(baseMap, comparedMap)) {
                        System.out.println("match! Base: " + s.substring(startIndex, startIndex + anagramSize) + " / " + s.substring(firstIndexOfComparedString, firstIndexOfComparedString + anagramSize));

                        matchedStartIndexes.add(startIndex);
                        numOfAnagrams++;
                    }

                    firstIndexOfComparedString++;
                }

                String addLetter = strings[startIndex + anagramSize];
                String removedLetter = strings[startIndex];
                shiftMapToRight(baseMap, addLetter, removedLetter);
            }

        }
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
