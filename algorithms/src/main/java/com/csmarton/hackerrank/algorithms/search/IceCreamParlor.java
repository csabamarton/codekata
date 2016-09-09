package com.csmarton.hackerrank.algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class IceCreamParlor {

    private Scanner in;
    private int money;
    private List<Integer> costs;

    public static void main(String[] args) {
        IceCreamParlor iceCreamParlor = new IceCreamParlor();

        iceCreamParlor.start();

    }

    private void start() {
        in = new Scanner(System.in);

        int numOfTestCases = in.nextInt();

        IntStream.range(0, numOfTestCases).forEach(i -> solve());
    }

    private void solve() {
        setInputData();

        boolean hasFound = false;

        for (int outerCounter = 0; outerCounter < costs.size() - 1; outerCounter++) {
            int cost = costs.get(outerCounter);

            for (int innerCounter = outerCounter + 1; innerCounter < costs.size(); innerCounter++) {
                int cost2 = costs.get(innerCounter);
                if (money - cost == cost2) {
                    System.out.println((outerCounter + 1) + " " + (innerCounter + 1));

                    break;
                }
            }

            if (hasFound) {
                break;
            }
        }
    }

    private void setInputData() {
        money = in.nextInt();
        int numOfIceCreams = in.nextInt();

        costs = new ArrayList<>(numOfIceCreams);

        IntStream.range(0, numOfIceCreams).forEach(i -> costs.add(in.nextInt()));
    }
}
