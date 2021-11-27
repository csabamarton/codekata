import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PermMissingElemTest {
    private PermMissingElem solution = new PermMissingElem();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {            }, 1 }),
                Arguments.of(new Object [] { new int [] {           8, 4, 7, 3, 2, 1, 5 }, 6 }),
                Arguments.of(new Object [] { new int [] {        6, 8, 4, 7, 3, 2, 1, 5 }, 9 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int pExpected) {
        int result = solution.solution(pA);
        assertEquals(pExpected, result);
    }
}