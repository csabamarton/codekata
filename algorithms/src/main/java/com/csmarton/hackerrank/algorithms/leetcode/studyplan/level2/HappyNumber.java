package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        int newNumber = 0;

        if (n == 1 || n== 7) return true;
        else if (n < 10) return false;

        while (n != 0) {
            newNumber += Math.pow(n%10,2);
            n = n/10;
        }

        return isHappy(newNumber);
    }

    int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy2(int n) {
        Set<Integer> visitedNumbers = new HashSet<>();

        while (n != 1 && !visitedNumbers.contains(n)) {
            visitedNumbers.add(n);

            n = getNext(n);
        }

        return n == 1;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        System.out.println(happyNumber.isHappy(19));
    }
}
