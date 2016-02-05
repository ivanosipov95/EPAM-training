package javase04.t03;


import java.io.*;

public class Reader {

    private String inPath;
    private String outPath;

    public Reader(String inPath, String outPath) {
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

    public void write(String inputData) {
        BufferedWriter writer = null;

        try {

            writer = new BufferedWriter(new FileWriter(outPath));
            writer.write(new String(inputData.getBytes(),"UTF-16"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException ignore) {

            }
        }

    }
}
