import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GroupTravellersTest {
    private GroupTravellers solution = new GroupTravellers();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {   1, 4, 1}, new int [] {1, 5, 1}, 2 }),
                Arguments.of(new Object [] { new int [] {   1}, new int [] {5}, 1 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int[] pB, int pExpected) {
        int result = solution.solution(pA, pB);
        assertEquals(pExpected, result);
    }
}