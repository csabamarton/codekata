package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LongestPalindrome {

    public int longestPalindrome(String[] words) {
        List<String> wordList = Arrays.asList(words);

        int max = 0;

        boolean hasTwin = false;

        Iterator<String> iterator = wordList.iterator();

        while (iterator.hasNext()) {
            String current = iterator.next();
            if(current == null) continue;

            String reverse = new String("" + current.charAt(1) + current.charAt(0));

            while ()
            for (int j = i + 1; j < words.length; j++) {
                if(words[j] == null)
                    continue;
                if (words[j].equals(reverse)) {
                    max += 4;
                    words[j] = null;

                    current = "";
                    break;
                }
            }

            if(!hasTwin && current.equals(reverse)) {
                max += 2;
                hasTwin = true;
            }
        }

        return max;
    }


}
