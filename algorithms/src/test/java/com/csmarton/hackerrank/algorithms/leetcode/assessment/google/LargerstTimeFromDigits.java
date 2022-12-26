package com.csmarton.hackerrank.algorithms.leetcode.assessment.google;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LargerstTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        if(Arrays.equals(arr, new int[]{0, 0, 0, 0}))
            return "00:00";

        LocalTime time = LocalTime.now().withHour(0).withMinute(0);
        boolean found = false;
        Arrays.sort(arr);

        while (!found) {
            time = time.minusMinutes(1);

            if (time.getHour() == 0 && time.getMinute() == 0)
                return "";

            String t = time.format(DateTimeFormatter.ofPattern("HHmm"));
            int[] dateArr = t.chars()
                    .map(x -> x - '0')
                    .sorted()
                    .toArray();
            if(t.equals("1000"))
                System.out.println();

            if(Arrays.equals(dateArr,arr))
                return time.format(DateTimeFormatter.ofPattern("HH:mm"));
        }

        return "";
    }

    public static void main(String[] args) {
        LargerstTimeFromDigits largerstTimeFromDigits = new LargerstTimeFromDigits();
        System.out.println(largerstTimeFromDigits.largestTimeFromDigits(new int[]{0, 0, 1, 0}));

        System.out.println(largerstTimeFromDigits.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(largerstTimeFromDigits.largestTimeFromDigits(new int[]{5, 5, 3, 3}));
    }
}
