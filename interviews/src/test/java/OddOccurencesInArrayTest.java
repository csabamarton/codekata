import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OddOccurencesInArrayTest {

    private OddOccurencesInArray solution = new OddOccurencesInArray();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {           9, 3, 9, 3, 9, 7, 9 }, 7 }),
                Arguments.of(new Object [] { new int [] {   8, 4, 6, 8, 15, 3, 4, 15, 6 }, 3 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int pExpected) {
        int result = solution.solution(pA);
        assertEquals(result, pExpected);
    }
}