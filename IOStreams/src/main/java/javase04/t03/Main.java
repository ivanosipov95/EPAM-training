package javase04.t03;


public class Main {

    public static void main(String[] args) {

        String input = "C:\\Users\\Ivano\\input.txt";
        String output = "C:\\Users\\Ivano\\out.txt";

        Reader reader = new Reader(input, output);

        reader.write(reader.read());
    }
}
