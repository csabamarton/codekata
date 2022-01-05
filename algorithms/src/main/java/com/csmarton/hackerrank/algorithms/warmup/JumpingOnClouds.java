package com.csmarton.hackerrank.algorithms.warmup;

import java.util.List;

public class JumpingOnClouds {
    public int solution(List<Integer> clouds) {
        int numOfRequiredJumps = 0;

        int currentCloud = 0;

        while (currentCloud < clouds.size()) {
            if(currentCloud >= clouds.size() - 3) {
                numOfRequiredJumps++;
                break;
            }

            if(clouds.get(currentCloud + 2) == 0) {
                currentCloud = currentCloud + 2;
            } else {
                currentCloud++;
            }

            numOfRequiredJumps++;
        }

        return numOfRequiredJumps;
    }
}
