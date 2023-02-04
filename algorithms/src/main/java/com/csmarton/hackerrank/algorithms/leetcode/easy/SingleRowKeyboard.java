package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {

    /*
    https://leetcode.com/problems/single-row-keyboard
     */
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> indexMap = new HashMap<>();

        for(int i = 0; i< keyboard.length(); i++) {
            indexMap.put(keyboard.charAt(i), i);
        }

        int numOfMoves = 0;
        int lastIndex = 0;

        for(int i = 0; i< word.length(); i++) {
            int targetIndex = indexMap.get(word.charAt(i));

            numOfMoves += Math.abs(targetIndex - lastIndex);
            lastIndex = targetIndex;
        }

        return numOfMoves;
    }
}
