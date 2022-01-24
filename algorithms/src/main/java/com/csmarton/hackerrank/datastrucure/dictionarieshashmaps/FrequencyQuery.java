package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.*;

public class FrequencyQuery {
    public List<Integer> solution(List<int[]> input) {
        List<Integer> printouts = new ArrayList<>();
        Map<Integer, Integer> numberMap = new HashMap<>();
        Map<Integer, Integer> numberCounts = new HashMap<>();

        Integer oldFreq;
        Integer newFreq;
        Integer oldOccurrence;
        Integer newOccurrence;

        for (int[] action : input) {
            int command = action[0];
            int number = action[1];

            if(command == 3) {
               printouts.add(numberCounts.get(number) == null ? 0:1);
            }else {
                oldFreq = numberMap.get(number);
                oldFreq = oldFreq == null ? 0 : oldFreq;
                oldOccurrence = numberCounts.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if(command == 1) newFreq = oldFreq + 1;
                else newFreq = oldFreq - 1;

                newOccurrence = numberCounts.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                if (newFreq < 1) {
                    numberMap.remove(number);
                } else {
                    numberMap.put(number, newFreq);
                }

                if ((oldOccurrence - 1) < 1) {
                    numberCounts.remove(oldFreq);
                } else {
                    numberCounts.put(oldFreq, oldOccurrence - 1);
                }
                numberCounts.put(newFreq, newOccurrence + 1);
            }
        }

        return printouts;
    }
}
