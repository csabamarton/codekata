import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {
    private FrogJump solution = new FrogJump();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { 10, 85, 30, 3 }),
                Arguments.of(new Object [] { 10, 100, 30, 3 }),
                Arguments.of(new Object [] { 10, 101, 30, 4 }),
                Arguments.of(new Object [] {   3, 20, 5, 4 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int pX, int pY, int pD, int pExpected) {
        int result = solution.solution(pX, pY, pD);
        assertEquals(result, pExpected);
    }
}