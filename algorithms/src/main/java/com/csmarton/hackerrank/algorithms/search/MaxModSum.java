package com.csmarton.hackerrank.algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class MaxModSum {

    private class TestCase {
        private long mod;
        private long[] numbers;

        public TestCase(long mod, long[] numbers) {
            this.mod = mod;
            this.numbers = numbers;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        MaxModSum maxModSum = new MaxModSum();

        maxModSum.start();
    }

    private void start() throws FileNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("maxmodsum/input14.txt").getFile());

        Scanner in = new Scanner(file);
        int numOfTestCases = in.nextInt();

        IntStream.range(0, numOfTestCases).forEach(i -> solve(in));

    }

    private void solve(Scanner in) {
        TestCase testCase = initTestCase(in);

        System.out.println(investigate(testCase));
    }

    private long investigate(TestCase testCase) {
        long[] numbers = testCase.numbers;

        long maxSumMod = 0;
        long mod = testCase.mod;

        int sizeOfArray = numbers.length;

        OptionalLong max = IntStream.range(0, sizeOfArray).mapToLong(i -> numbers[i]).max();

        maxSumMod = max.getAsLong();

        for (int i = 1; i < sizeOfArray; i++) {
            long sum = numbers[i - 1] + numbers[i];

            if (sum > mod) {
                sum = sum - mod;
            } else if (sum == mod) {
                sum = 0;
            }

            numbers[i] = sum;

            if (sum > maxSumMod) {
                maxSumMod = sum;
            }
        }

        TreeSet<Long> set = new TreeSet<>();
        set.add(numbers[0]);
        
        for (Long i = 2L; i < numbers.length; i++) {
            Long currentNumber = numbers[i.intValue()];
            Long ceiling = set.ceiling(currentNumber);
            if (ceiling == null) {
                set.add(numbers[i.intValue() - 1]);
                continue;
            }

            if (ceiling.equals(currentNumber)) {
                set.remove(ceiling);
                Long greaterCeiling = set.ceiling(currentNumber);
                if (greaterCeiling == null) {
                    set.add(ceiling);
                    set.add(numbers[i.intValue() - 1]);
                    continue;
                }
                set.add(ceiling);
                ceiling = greaterCeiling;
            }
            Long newMax = (currentNumber - ceiling + mod);
            maxSumMod = maxSumMod > newMax ? maxSumMod : newMax;
            set.add(numbers[i.intValue() - 1]);
        }

        return maxSumMod;
    }

    private TestCase initTestCase(Scanner in) {
        int sizeOfArray = in.nextInt();
        long mod = in.nextLong();

        long[] numbers = new long[sizeOfArray];

        IntStream.range(0, sizeOfArray)
                .forEach(i -> numbers[i] = reduceWithMod(in.nextLong(), mod));

        return new TestCase(mod, numbers);
    }

    private long reduceWithMod(long number, long mod) {
        if (number > mod) {
            return number % mod;
        }

        return number;
    }
}
