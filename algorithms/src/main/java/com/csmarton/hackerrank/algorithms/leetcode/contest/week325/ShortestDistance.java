package com.csmarton.hackerrank.algorithms.leetcode.contest.week325;

import java.util.Map;

public class ShortestDistance {
    public int closetTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target))
            return 0;

        int right = startIndex, left = startIndex;

        for (int i = 1; i <= words.length; i++) {
            right = right == words.length - 1 ? 0 : right + 1;
            left = left == 0 ? words.length - 1 : left - 1;

            if(words[right].equals(target) || words[left].equals(target))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistance shortestDistance = new ShortestDistance();

        System.out.println(shortestDistance.closetTarget(new String[]{"pgmiltbptl","jnkxwutznb","bmeirwjars","ugzyaufzzp","pgmiltbptl","sfhtxkmzwn","pgmiltbptl","pgmiltbptl","onvmgvjhxa","jyzdtwbwqp"}, "pgmiltbptl", 4));

        System.out.println(shortestDistance.closetTarget(new String[]{"hello","i","am","leetcode","hello"}, "hello", 1));
        System.out.println(shortestDistance.closetTarget(new String[]{"hello","i","am","leetcode","hello"}, "d", 4));
    }
}
