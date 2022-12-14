package com.csmarton.hackerrank.algorithms.leetcode.easy.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Fizzbuzz {

   /*
   Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
    */
    public List<String> fizzBuzz(int n) {
        List<String> answers = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            boolean divby3 = i % 3 == 0;
            boolean divby5 = i % 5 == 0;

            if(divby3 && divby5)
                answers.add("FizzBuzz");
            else if(divby3) {
                answers.add("Fizz");
            } else if(divby5) {
                answers.add("Buzz");
            } else
                answers.add(String.valueOf(i));
        }

        return answers;
    }
}
