package javase04.t01;


public class Main {

    public static void main(String[] args) {
        String input = "C:\\Users\\Ivano\\EPAM-training\\JavaFundamentals\\src\\main\\java\\javase01\\t04\\MaxFinder.java";
        String output = "C:\\Users\\Ivano\\out.txt";

        KeywordsReader reader = new KeywordsReader(input, output);

        reader.write(reader.getKeywords(reader.read()));
    }
}
