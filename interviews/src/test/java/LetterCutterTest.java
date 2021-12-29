import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LetterCutterTest {
    private LetterCutter solution = new LetterCutter();

    static Stream<Arguments> intArrayProvider() {
        return Stream.of(
                Arguments.of(new Object [] { "Codility We test coders", 14, "Codility We"}),
                Arguments.of(new Object [] { "Codility We test coders", 100, "Codility We test coders"}),
                Arguments.of(new Object [] { "Codility We test coders", 1, ""}),
                Arguments.of(new Object [] { "To crop or not to crop", 21, "To crop or not to"}),
                Arguments.of(new Object [] { "T", 5, "T"}),
                Arguments.of(new Object [] { "dfT", 1, ""}),
                Arguments.of(new Object [] { "Codility We test coders", 9, "Codility"}),
                Arguments.of(new Object [] { "The quick brown fox jumps over the lazy dog", 39, "The quick brown fox jumps over the lazy"})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    public void verifySolution(String pText, int pLimit, String pExpected) {
        String result = solution.solution(pText, pLimit);
        assertEquals(pExpected, result);
    }

}