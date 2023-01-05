package com.csmarton.hackerrank.algorithms.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagrams {

    public List<Integer> findAnagramsWithMap(String s, String p) {

        Map<Character, Integer> searchMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            if(searchMap.containsKey(c))
                searchMap.put(c, searchMap.get(c) + 1);
            else
                searchMap.put(c, 1);
        }

        Map<Character, Integer> baseMap = new HashMap<>();

        int length = p.length();
        for (char c : s.substring(0, length).toCharArray()) {
            if(baseMap.containsKey(c))
                baseMap.put(c, baseMap.get(c) + 1);
            else
                baseMap.put(c, 1);
        }

        List<Integer> anagramsAt = new ArrayList<>();

        if(baseMap.equals(searchMap))
            anagramsAt.add(0);

        for (int i = length; i < s.length(); i++) {
            char c = s.charAt(i);

            char oldChar = s.charAt(i - length);

            if(baseMap.get(oldChar) == 1)
                baseMap.remove(oldChar);
            else
                baseMap.put(oldChar, baseMap.get(oldChar) - 1);

            if(baseMap.containsKey(c))
                baseMap.put(c, baseMap.get(c) + 1);
            else
                baseMap.put(c, 1);

            if(baseMap.equals(searchMap))
                anagramsAt.add(i - length - 1);
        }

        return anagramsAt;
    }


    public List<Integer> findAnagrams(String s, String p) {
        int numOfAnagrams = 0;

        int length = p.length();
        String base = s.substring(0, length);
        char tempArray[] = base.toCharArray();
        Arrays.sort(tempArray);
        base = new String(tempArray);
        StringBuilder sb = new StringBuilder(base);

        tempArray = p.toCharArray();
        Arrays.sort(tempArray);
        String search = new String(tempArray);

        if(sb.toString().equals(search))
            numOfAnagrams++;

        for (int i = length; i < s.toCharArray().length; i++) {
            char oldChar = s.charAt(i - length);

            base.replaceFirst(String.valueOf(oldChar), String.valueOf(s.charAt(i)));

            tempArray = base.toCharArray();
            Arrays.sort(tempArray);
            base = new String(tempArray);

            if(base.equals(search))
                numOfAnagrams++;

        }


        return null;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();

        System.out.println(findAnagrams.findAnagramsWithMap("cbaebabacd", "abc"));
    }


}
