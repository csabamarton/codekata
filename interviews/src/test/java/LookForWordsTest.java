import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LookForWordsTest {

    private LookForWords lookForWords = new LookForWords();
    private static Path targetPath = Paths.get(LookForWords.class.getResource("/").getPath());


    @BeforeAll
    public static void setup() throws IOException {
        Path resultFolder = Paths.get(targetPath.toAbsolutePath() + "/result/");
        //cleanUp
        FileUtils.deleteDirectory(resultFolder.toFile());
        Files.createDirectories(resultFolder);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        Path resultFolder = Paths.get(targetPath.toAbsolutePath() + "/result/");
        FileUtils.deleteDirectory(resultFolder.toFile());
    }

    @Test
    public void giveOneLineWithUpperCaseDuplication_AndNoCaseSenitivity_ThenPutRightMap() {
        Map<String, String> wordsInLine = new HashMap<>();

        String testLine = "Peter is hungry is peter";

        lookForWords.processLine(wordsInLine, testLine, 1, false);

        assertEquals(wordsInLine.size(), 4);
        assertTrue(wordsInLine.containsKey("Peter"));
        assertEquals(wordsInLine.get("peter"), "1");
    }

    @Test
    public void giveOneLineWithUpperCaseDuplication_AndCaseSenitivity_ThenPutRightMap() {
        Map<String, String> wordsInLine = new HashMap<>();

        String testLine = "Peter is hungry is peter";

        lookForWords.processLine(wordsInLine, testLine, 1, true);

        assertEquals(wordsInLine.size(), 3);
        assertFalse(wordsInLine.containsKey("Peter"));
        assertEquals(wordsInLine.get("peter"), "1");
    }

    @Test
    public void giveOneLine_ThenPutMap() {
        Map<String, String> wordsInLine = new HashMap<>();

        String testLine = "Peter is hungry is peter";

        lookForWords.processLine(wordsInLine, testLine, 1, false);

        assertEquals(wordsInLine.size(), 4);
        assertTrue(wordsInLine.containsKey("Peter"));
        assertEquals(wordsInLine.get("Peter"), "1");
    }

    @Test
    public void givenInputFileName_thenCleanAndGiveBackOutPutFilePath() throws IOException {
        String inputFileName = "alma";

        Path resultFilePath = lookForWords.setupResultFile(targetPath, inputFileName);

        assertNotNull(resultFilePath);

        String path = resultFilePath.toAbsolutePath().toString();
        assertTrue(path.endsWith("-index.txt"));
    }

}