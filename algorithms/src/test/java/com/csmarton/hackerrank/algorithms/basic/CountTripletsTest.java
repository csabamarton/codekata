package com.csmarton.hackerrank.algorithms.basic;

import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class CountTripletsTest {
    CountTriplets countTriplets = new CountTriplets();

    private Path workingDir;

    @Before
    public void init() {
        this.workingDir = Path.of("", "src/test/resources");
    }

    private static Stream<Arguments> paramProvider() throws IOException {
        List<Long> tests = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            tests.add(1237L);
        }

        return Stream.of(
                Arguments.of(List.of(1,1,1,1,1,1), 1, 20),
                Arguments.of(List.of(1,1,1,1,1,1,1), 1, 35),
                Arguments.of(List.of(1, 1, 1, 1, 1,1,1,1), 1, 56),
                Arguments.of(List.of(1, 1, 1, 1, 1,1,1,1,1), 1, 84),
                Arguments.of(List.of(1, 1, 1, 1, 1,1,1,1,1,1), 1, 120),
                Arguments.of(List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 1, 161700),
                createArguments("triplet2", 1339347780085L),
                createArguments("triplet", 2325652489L),
                Arguments.of(List.of(1, 1, 1, 1, 1,1, 2, 2, 2, 2, 2, 2), 1, 40),
                Arguments.of(tests, 1, 166661666700000L),
                Arguments.of(List.of(6,9,1, 5, 1, 5, 25, 125), 5, 5),
                Arguments.of(List.of(1,4, 16, 64), 4, 2),
                Arguments.of(List.of(1,2,2,4), 2, 2),
                Arguments.of(List.of(1, 3, 9, 9, 27, 81), 3, 6)
                );
    }

    private static Arguments createArguments(String testFileName, long expectedResult) throws IOException {
        Path workingDir = Path.of("", "src/test/resources");
        Path file = workingDir.resolve(testFileName);

        BufferedReader reader = new BufferedReader(new FileReader(file.toString()));

        BufferedReader bufferedReader = reader;
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        bufferedReader.close();

        return Arguments.of(arr, r, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Long> numbers, long ratio, long expectedNumOfTriplets) {
        long result = countTriplets.solution(numbers, ratio);

        assertEquals(expectedNumOfTriplets, result);
    }

}