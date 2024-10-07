package com.csmarton.hackerrank.algorithms.daily.day4;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private static final Map<Character, Character> parentPairs =
            Map.of('(', ')', '[',']','{','}');

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (parentPairs.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()) return false;
                Character last = stack.pop();
                if (!parentPairs.get(last).equals(s.charAt(i))) return false;
            }
        }

        return stack.empty();
    }
}
