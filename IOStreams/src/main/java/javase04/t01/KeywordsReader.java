package javase04.t01;

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
        FileInputStream input = null;
        StringBuilder inputData = new StringBuilder();
        byte[] buff = new byte[100];

        try {

            input = new FileInputStream(inPath);

            while ((input.read(buff)) != -1) {
                inputData.append(new String(buff, "UTF-8"));
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
        FileOutputStream output = null;
        DataOutputStream stream = null;
        try {

            output = new FileOutputStream(outPath);
            stream = new DataOutputStream(output);

            for (Map.Entry<String, Integer> e : keywords.entrySet()) {
                stream.writeBytes(e.getKey() + " ");
                stream.writeBytes(e.getValue() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stream.flush();
                stream.close();
                output.close();
            } catch (IOException ignore) {

            }
        }
    }
}
