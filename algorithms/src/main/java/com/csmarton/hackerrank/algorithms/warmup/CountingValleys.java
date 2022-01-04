package com.csmarton.hackerrank.algorithms.warmup;

import java.util.List;
import java.util.stream.Collectors;

public class CountingValleys {
    public int solve(int steps, String path) {
        boolean isItAValley = false;
        int currentAltitude = 0;
        int numOfValleys = 0;

        List<Character> stepList = path.chars().mapToObj(i -> (char) i)
                .collect(Collectors.toList());

        for (Character step: stepList) {
            currentAltitude = currentAltitude + (step.charValue() == 'U' ? 1 : -1);

            if (isItAValley && currentAltitude == 0) {
                numOfValleys++;
                isItAValley = false;
            } else if (!isItAValley && currentAltitude < 0) {
                isItAValley = true;
            }
        }

        return numOfValleys;
    }
}
