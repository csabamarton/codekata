package com.csmarton.hackerrank.algorithms.leetcode.easy.string;

import java.util.Set;
import java.util.stream.Collectors;

public class IsSubsequence {

    public boolean isSubsequence4(String s, String t) {
       return next(s, t, 0, 0);
    }

    private boolean next(String s, String t, int sIndex, int tIndex) {
        if(sIndex == s.length())
            return true;

        if(tIndex == t.length())
            return false;

        int firstOccurence = t.indexOf(s.charAt(sIndex), tIndex);

        if(firstOccurence == -1)
            return false;

        return next(s, t, sIndex + 1, firstOccurence + 1);
    }


    public boolean isSubsequence(String s, String t) {
       int sIndex = 0, tIndex = 0;

        while (sIndex < s.length()) {
            int first = t.indexOf(s.charAt(sIndex), tIndex);
            if (first == -1)
                return false;

            if(first == t.length() - 1 && sIndex < s.length() - 1)
                return false;
            tIndex = first + 1;
            sIndex++;
        }

        return sIndex == s.length();
    }

    public boolean isSubsequence3(String s, String t) {
        //iterate on s
        int index = -1;
        Set<Character> charsSet = s.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        for (int i = 0; i < t.length(); i++) {
            if (!charsSet.contains(t.charAt(i)))
                continue;
            index++;

            if(index == s.length())
                return false;

            if(t.charAt(i) != s.charAt(index)) {
                return false;
            }


        }

        return index == s.length() - 1;
    }

    public boolean isSubsequence2(String s, String t) {
        Set<Character> charsSet = s.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if(charsSet.contains(t.charAt(i)))
                sb.append(t.charAt(i));
        }

        return sb.toString().equals(s);
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();

        System.out.println(isSubsequence.isSubsequence("b", "c"));
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("ab", "baab"));
    }
}
