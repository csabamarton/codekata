package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class FrequencyQueryTest {

    FrequencyQuery frequencyQuery = new FrequencyQuery();

    private static Stream<Arguments> paramProvider() throws IOException {
        return Stream.of(
                createArguments("input1", "result1"),
                Arguments.of(
                        List.of(
                                new int[]{3,4},
                                new int[]{2, 1003},
                                new int[]{1, 16},
                                new int[]{3, 1}
                        ),
                        List.of(0,1))
        );
    }

    private static List<Integer> createResultList(String testFileName) throws IOException {
        Path workingDir = Path.of("", "src/test/resources/frequencyquery");
        Path file = workingDir.resolve(testFileName);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString()));;

        List<Integer> result = new ArrayList<>();
        String thisLine;
        while ((thisLine = bufferedReader.readLine()) != null) {
            result.add(Integer.parseInt(thisLine.trim()));
        };

        bufferedReader.close();

        return result;
    }

    private static Arguments createArguments(String testFileName, String expectedResultFileName) throws IOException {
        List<Integer> resultList = createResultList(expectedResultFileName);

        Path workingDir = Path.of("", "src/test/resources/frequencyquery");
        Path file = workingDir.resolve(testFileName);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString()));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<int[]> queries = new ArrayList<>(q);
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
            int[] query = new int[2];
            Matcher m = p.matcher(bufferedReader.readLine());
            if (m.matches()) {
                query[0] = Integer.parseInt(m.group(1));
                query[1] = Integer.parseInt(m.group(2));
                queries.add(query);
            }
        }

        bufferedReader.close();

        return Arguments.of(queries, resultList);
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<int[]> input, List<Integer> expectedResult) throws Exception {
       List<Integer> solution = frequencyQuery.solution(input);
       //List<Integer> solution = frequencyQuery.freqQuery(input);

        assertNotNull(solution);
        assertArrayEquals(expectedResult.toArray(), solution.toArray());

    }
}