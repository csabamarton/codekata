package com.csmarton.hackerrank.week23;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GearsOfWar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfQueries = in.nextInt();

        IntStream.range(0,numOfQueries).forEach(i -> solve(in));
    }

    private static void solve(Scanner in) {
        int numOfGears = in.nextInt();
        System.out.println(numOfGears % 2 == 0?"YES":"NO");
    }
}
