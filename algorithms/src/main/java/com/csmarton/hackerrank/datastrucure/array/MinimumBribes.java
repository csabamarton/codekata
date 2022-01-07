package com.csmarton.hackerrank.datastrucure.array;

import java.util.*;

public class MinimumBribes {

    /*
    find first minus and plus

    1  2  | 5  3  7  8  6  4
    0  0  | 2  -1 2  2 -1 -4  - flip 5 with 3

    1  2  3 | 5  7  8  6  4
    0  0  0 | 1  2  2 -1 -4  - flip 6 with 4    Map(5->1, 6->1)

    1  2  3 | 5  7  8  4  6
    0  0  0 | 1  2  2 -1 -4  - flip 8 with 4    Map(5->1, 6->1, 8->4)

    1  2  3 | 5  7  4  8  6
    0  0  0 | 1  2  2 -1 -4  - flip 7 with 4    Map(5->1, 6->1, 8->4, 7->4)

    1  2  3 | 5  4  7  8  6
    0  0  0 | 1  2  2 -1 -4  - flip 5 with 4    Map(5->2, 6->1, 8->4, 7->4)

    1  2  3 4 | 5  7  8  6
    0  0  0 1 | 2  2 -1 -4  - flip 5 with 4    Map(5->2, 6->1, 8->4, 7->4)
    */

    public int solution(List<Integer> queue) throws Exception {
        int numOfBribes = 0;

        int fixQueueIndex = 0;

        Map<Integer, Integer> bribeMap = new HashMap<>();

        while (fixQueueIndex < queue.size()) {
            int nextIndex = findNextSortingElement(fixQueueIndex, queue);

            boolean isAtRightPosition = nextIndex == fixQueueIndex;

            while(!isAtRightPosition) {
                Collections.swap(queue, nextIndex - 1, nextIndex);

                Integer briber = queue.get(nextIndex);
                numOfBribes++;

                if(bribeMap.containsKey(briber)) {
                    bribeMap.put(briber, bribeMap.get(briber) + 1);
                } else {
                    bribeMap.put(briber, 1);
                }
                if(bribeMap.get(briber) > 2) {
                    System.out.println("Too Chaotic");
                    return -1;
                }

                nextIndex--;

                isAtRightPosition = nextIndex == fixQueueIndex;
            }

            fixQueueIndex++;
        }

        return numOfBribes;
    }

    private int findNextSortingElement(int fixQueueIndex, List<Integer> queue) throws Exception {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == fixQueueIndex + 1)
                return i;
        }

        throw new Exception("Wrong test Case. Missing number: " + fixQueueIndex + 1);
    }

    public int solution2(List<Integer> initialQueue) {
        int sumDistances = 0;

        boolean notPerfectQueue = true;

        //while (notPerfectQueue) {
            notPerfectQueue = false;
            for (int i = 0; i < initialQueue.size(); i++) {
                if (initialQueue.get(i) - i - 1 != 0) {
                    notPerfectQueue = true;
                    break;
                }
            }

            if(false){
                for (int i = 0; i < initialQueue.size(); i++) {

                    int currentDist = initialQueue.get(i) - i - 1;
                    int nextDist = initialQueue.get(i + 1) - i;

                    if(currentDist > 0 && nextDist < 0) {
                        Integer temp = initialQueue.get(i);
                        initialQueue.set(i, initialQueue.get(i+1));
                        initialQueue.set(i + 1, temp);
                    }
                }
            }
        //}

        return sumDistances;
    }
}
