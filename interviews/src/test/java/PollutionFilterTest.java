import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PollutionFilterTest {
    private PollutionFilter solution = new PollutionFilter();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {         5, 19, 8, 1   }, 3 }),
                Arguments.of(new Object [] { new int [] {           10, 10 }, 2 }),
                Arguments.of(new Object [] { new int [] {        3, 0, 5 }, 2 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int pExpected) {
        int result = solution.solution(pA);
        assertEquals(pExpected, result);
    }
}