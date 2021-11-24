import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LookForWords {

    public static void main(String[] args) throws IOException {
        LookForWords lookForWords = new LookForWords();
        lookForWords.processInputFile("example");
    }

    private void processInputFile(String inputFileName) throws IOException {
        ClassLoader classLoader = LookForWords.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(inputFileName + ".txt");

        Map<String, String> result = readFromInputStream(inputStream);

        Path targetPath = Paths.get(this.getClass().getResource("/").getPath());
        writeOutResult(result, inputFileName, targetPath);

        System.out.println(result);
    }

    private Map readFromInputStream(InputStream inputStream)
            throws IOException {
        Map<String, String> wordsInLine = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int lineNum = 1;

            while ((line = br.readLine()) != null) {
                processLine(wordsInLine, line, lineNum, true);
                lineNum++;
            }
        }
        return wordsInLine;
    }

    public void processLine(Map<String, String> wordsInLine, String line, int lineNum, boolean caseSensititve) {
        Stream<String> stream = Arrays.stream(line.split(" "));

        if(caseSensititve) {
            stream = stream.map(String::toLowerCase);
        }
        List<String> words = stream.distinct().collect(Collectors.toList());

        for (String word : words) {
            if (!wordsInLine.containsKey(word)) {
                wordsInLine.put(word, Integer.toString(lineNum));
            } else {
                String wordLineNums = wordsInLine.get(word);
                wordsInLine.put(word, wordLineNums + "," + lineNum);
            }
        }
    }

    private void writeOutResult(Map<String, String> result, String inputFileName, Path targetPath) throws IOException {
        SortedSet<String> keys = new TreeSet<>(result.keySet());

        Path fullResultFilePath = setupResultFile(targetPath, inputFileName);

        try (BufferedWriter writer = Files.newBufferedWriter(fullResultFilePath))
        {
            for (String key: keys) {
                writer.write(key + " " + result.get(key) + System.lineSeparator());
            }
        }
    }

    public Path setupResultFile(Path targetPath, String inputFileName) throws IOException {
        Path resultFolder = Paths.get(targetPath.toAbsolutePath() + "/result/");

        //cleanUp
        FileUtils.deleteDirectory(resultFolder.toFile());
        Files.createDirectories(resultFolder);

        Path fullResultFilePath = resultFolder.resolve(inputFileName + "-index.txt");
        return fullResultFilePath;
    }
}
