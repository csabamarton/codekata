package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class CheckMagazine {
    public boolean solution(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWordsUsage = new HashMap<>();
        magazine.forEach(word -> {
            if(!magazineWordsUsage.containsKey(word)){
                magazineWordsUsage.put(word, 1);
            } else {
                magazineWordsUsage.put(word, magazineWordsUsage.get(word) + 1);
            }
        });

        for (String neededWord : note) {
            if(!magazineWordsUsage.containsKey(neededWord)){
                System.out.println("No");
                return false;
            }
            if(magazineWordsUsage.get(neededWord) == 0) {
                System.out.println("No");
                return false;
            }
            magazineWordsUsage.put(neededWord, magazineWordsUsage.get(neededWord) - 1);
        }

        System.out.println("Yes");
        return true;
    }
}
