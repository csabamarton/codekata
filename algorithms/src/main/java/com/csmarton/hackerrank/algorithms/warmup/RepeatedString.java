package com.csmarton.hackerrank.algorithms.warmup;

public class RepeatedString {
    public int solution(String s, long n) {
        long index = 0;
        int letterIndex = 0;
        int numOfOccurences = 0;

        char[] letters = s.toCharArray();

        while (index < n) {
            char letter = letters[letterIndex];
            if (letter == 'a')
                numOfOccurences++;

            index++;
            letterIndex++;
            if (letterIndex == letters.length)
                letterIndex = 0;
        }

        return numOfOccurences;
    }

    public long solution2(String s, long n) {
        long numOfRepetitions = n / s.length();
        int letterIndex = 0;
        long numOfOccurences = 0;
        char[] letters = s.toCharArray();

        while (letterIndex < letters.length) {
            char letter = letters[letterIndex];
            if (letter == 'a')
                numOfOccurences++;

            letterIndex++;
        }

        numOfOccurences = numOfOccurences * numOfRepetitions;

        long modulo = n - (letters.length * numOfRepetitions);

        for (int i = 0; i < modulo; i++) {
            char letter = letters[i];
            if (letter == 'a')
                numOfOccurences++;
        }

        return numOfOccurences;
    }
}
