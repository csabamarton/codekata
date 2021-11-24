import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SmallestIntTest {
    private SmallestInt solution = new SmallestInt();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { new int [] {              1, 3, 6, 4, 1, 2 }, 5 }),
                Arguments.of(new Object [] { new int [] {           1, 3, 6, 4, 1, 2, 5 }, 7 }),
                Arguments.of(new Object [] { new int [] {                       1, 2, 3 }, 4 }),
                Arguments.of(new Object [] { new int [] {                         -1,-3 }, 1 }),
                Arguments.of(new Object [] { new int [] {                      -1,-3, 2 }, 1 }),
                Arguments.of(new Object [] { new int [] {                      -1,-3, 1 }, 2 }),
                Arguments.of(new Object [] { new int [] {                             0 }, 1 }),
                Arguments.of(new Object [] { new int [] {                      -1000000 }, 1 }),
                Arguments.of(new Object [] { new int [] {             -1000000,       1 }, 2 }),
                Arguments.of(new Object [] { new int [] {                       1000000 }, 1 }),
                Arguments.of(new Object [] { new int [] {       999999, 999998, 1000000 }, 1 }),
                Arguments.of(new Object [] { new int [] { 1, 3, 999999, 999998, 1000000 }, 2 })
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(int [] pA, int pExpected) {
        int result = solution.solution(pA);
        assertEquals(result, pExpected);
    }
}