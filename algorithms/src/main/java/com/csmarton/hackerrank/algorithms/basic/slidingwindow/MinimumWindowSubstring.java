package com.csmarton.hackerrank.algorithms.basic.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumWindowSubstring {
    public String findMinimumSubstring(String s, String t) {
        //Create frequency map of characters from t string
        Map<Character, Long> freq = t.chars().mapToObj(c -> (char) c).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                )
        );
        int left = 0;
        int right = 0;

        Map<Character, Long> freqInS = new HashMap<>();

        //create another Map, loop through
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            freqInS.put(c, freqInS.getOrDefault(c, 0L) + 1);




            //loop through freq map and compare it with freqInS map. I have to check whether freqInS contains exactly the same key values

            //check whether freq contains the same values

        }





        return null;
    }


    public static <Character> Map<Character, Long>  frequencyMap(Stream<Character> elements) {
        return elements.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new, // can be skipped
                        Collectors.counting()
                )
        );
    }
}
