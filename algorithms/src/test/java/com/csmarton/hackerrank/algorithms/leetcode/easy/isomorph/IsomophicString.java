package com.csmarton.hackerrank.algorithms.leetcode.easy.isomorph;

import java.util.HashMap;
import java.util.Map;

public class IsomophicString {

    public boolean isIsomorphic(String s, String t) {
        final Map<Character, Character> sChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sChars.containsKey(s.charAt(i))) {
                if(sChars.values().contains(t.charAt(i)))
                    return false;
                sChars.put(s.charAt(i), t.charAt(i));
            }
            else if (sChars.get(s.charAt(i)) != t.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        IsomophicString isomophicString = new IsomophicString();

        System.out.println(isomophicString.isIsomorphic("egg", "add"));
        System.out.println(isomophicString.isIsomorphic("foo", "bar"));
    }
}
