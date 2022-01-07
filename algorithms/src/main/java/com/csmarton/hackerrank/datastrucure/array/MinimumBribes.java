package com.csmarton.hackerrank.datastrucure.array;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

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
        Map<Integer, Integer> queuePositions = IntStream.range(0, queue.size())
                .boxed()
                .collect(toMap(queue::get, i -> i));

        int numOfBribes = 0;
        int fixQueueIndex = 0;
        Map<Integer, Integer> bribeMap = new HashMap<>();

        while (fixQueueIndex < queue.size()) {
            int nextIndex = queuePositions.get(fixQueueIndex + 1);

            boolean isAtRightPosition = nextIndex == fixQueueIndex;

            while(!isAtRightPosition) {
                queuePositions.put(queue.get(nextIndex), nextIndex - 1);
                queuePositions.put(queue.get(nextIndex - 1), nextIndex );

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
}
