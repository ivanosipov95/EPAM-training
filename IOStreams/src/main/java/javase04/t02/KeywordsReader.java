package javase04.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordsReader {

    private String inPath;
    private String outPath;

    public KeywordsReader(String inPath, String outPath) {
        this.inPath = inPath;
        this.outPath = outPath;
    }

    public String read() {

        FileReader input = null;
        StringBuilder inputData = new StringBuilder();
        char[] buff = new char[20];

        try {

            input = new FileReader(inPath);
            while (input.read(buff) != -1) {
                inputData.append(buff);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                input.close();
            } catch (IOException ignore) {

            }
        }

        return inputData.toString();
    }

    public Map<String, Integer> getKeywords(String inputData) {
        Map<String, Integer> keywords = new HashMap<>();
        Pattern pattern = Pattern.compile("byte|short|int|long|char|float|double|boolean" +
                "if|else|switch|case|default|while|do|break|continue|for|try|catch|finally|" +
                "throw|throws|private|protected|public|import|package|class|interface|extends|" +
                "implements|static|final|void|abstract|native|new|return|this|super|synchronized|" +
                "volatile|const|goto|instanceof|enum|assert|transient|strictfp");

        Matcher matcher = pattern.matcher(inputData);

        while (matcher.find()) {
            String group = matcher.group();
            if (keywords.containsKey(group)) {

                Integer i = keywords.get(group);
                keywords.put(group, ++i);
            } else {
                keywords.put(group, 1);
            }
        }
        return keywords;
    }

    public void write(Map<String, Integer> keywords) {
        BufferedWriter writer = null;
        try {

            writer = new BufferedWriter(new FileWriter(outPath));

            for (Map.Entry<String, Integer> e : keywords.entrySet()) {
                writer.write(e.getKey() + " " + e.getValue() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException ignore) {

            }
        }
    }
}
