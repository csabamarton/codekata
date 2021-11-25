import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {
    private CyclicRotation solution = new CyclicRotation();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {3, 8, 9, 7, 6}, 1, new int[] {6, 3, 8, 9, 7}}),
                Arguments.of(new Object [] { new int [] {3, 8, 9, 7, 6}, 2, new int[] {7, 6, 3, 8, 9}}),
                Arguments.of(new Object [] { new int [] {3, 8, 9, 7, 6}, 3, new int[] {9, 7, 6, 3, 8}}),
                Arguments.of(new Object [] { new int [] {}, 1, new int[] {}})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int numOfRotation, int [] pExpected) {
        int[] result = solution.solution(pA, numOfRotation);
        assertArrayEquals(result, pExpected);
    }
}