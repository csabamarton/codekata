import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {
    private BinaryGap solution = new BinaryGap();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { 9, 2 }),
                Arguments.of(new Object [] { 529, 4 }),
                Arguments.of(new Object [] { 20, 1 }),
                Arguments.of(new Object [] { 15, 0 }),
                Arguments.of(new Object [] { 32, 0 }),
                Arguments.of(new Object [] { 8, 0 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int pA, int pExpected) {
        int result = solution.solution(pA);
        assertEquals(result, pExpected);
    }
}