package com.csmarton.hackerrank.algorithms.basic;

import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class CountApplesAndOranges {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public long[] countApplesAndOranges(int s, int t, int a, int b, int[] appleInput, int[] orangeInput) {
        List<Integer> apples = IntStream.of(appleInput).boxed().collect(toList());
        List<Integer> oranges = IntStream.of(orangeInput).boxed().collect(toList());

        long numOfAppleOntheRoof = apples.stream().filter(distance -> a + distance >= s && a + distance <= t).count();

        long numOfOrangeOntheRoof = oranges.stream().filter(distance -> b + distance >= s && b + distance <= t).count();

        System.out.println(numOfAppleOntheRoof);
        System.out.println(numOfOrangeOntheRoof);

        return new long[] {numOfAppleOntheRoof, numOfOrangeOntheRoof};
    }
}
