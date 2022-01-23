package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.*;

public class FrequencyQuery {
    public List<Integer> solution(List<int[]> input, List<Integer> expectedResult) throws Exception {
        List<Integer> printouts = new ArrayList<>();
        Map<Integer, Long> numberMap = new HashMap<>();

        int i = 0;
        for (int[] action : input) {
            int command = action[0];
            int number = action[1];
            if(command == 1) {
                if(!numberMap.containsKey(number))
                    numberMap.put(number, 1L);
                else
                    numberMap.put(number, numberMap.get(number) + 1);
            } else if(command == 2) {
                if(numberMap.containsKey(number))
                {
                    Long numInMap = numberMap.get(number);
                    if (numInMap == 1) numberMap.remove(number);
                    else numberMap.put(number, numInMap--);
                }
            } else if(command == 3) {
                Optional<Long> result = numberMap.values().stream().filter(value -> number == value).findFirst();
                printouts.add(result.isPresent() ? 1 : 0);
                System.out.println();
                i++;
            } else throw new Exception("Wrong data");
        }

        return printouts;
    }
}
