package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    boolean isValid(String s) {
        Map<Character, Character> bracets = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack<>();

        Collection<Character> values = bracets.values();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(bracets.containsKey(c)) {
                stack.push(bracets.get(c));
            } else {
                Character pop = stack.pop();
                if(pop == null)
                    return false;
                if(pop != c) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
