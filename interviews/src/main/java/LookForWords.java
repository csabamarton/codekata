import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LookForWords {

    public static void main(String[] args) throws IOException {

        LookForWords lookForWords = new LookForWords();
        ClassLoader classLoader = LookForWords.class.getClassLoader();
        String inputFilename = "example";
        InputStream inputStream = classLoader.getResourceAsStream(inputFilename + ".txt");


        String expected_value = "Hello, world!";

        Path source = Paths.get(LookForWords.class.getResource("/").getPath());
        Path path = Paths.get("src/test/resources/fileTest.txt");

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        try {
            Map<String, String> result = lookForWords.readFromInputStream(inputStream);


            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(new File(source.toAbsolutePath() + inputFilename + "-index.txt")), StandardCharsets.UTF_8));
            result.forEach((key, value) -> {
                try {
                    writer.write(key + " " + value + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
            writer.close();

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();

        Map<String, String> wordsInLine = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int lineNum = 1;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if(!wordsInLine.containsKey(word)) {
                        wordsInLine.put(word, Integer.toString(lineNum));
                    } else {
                        String wordLineNums = wordsInLine.get(word);
                        wordsInLine.put(word, wordLineNums + "," + lineNum);
                    }
                }
                //resultStringBuilder.append(line).append("\n");
                lineNum++;
            }
        }
        return wordsInLine;
    }
}
