package javase04.t04;

import java.io.*;
import java.util.HashSet;

public class Collections extends HashSet<Film> {

    static final String FILE = "C:\\Users\\Ivano\\test.txt";

    public static void save(Collections collections) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
                for (Film film : collections) {
                    oos.writeObject(film);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collections restore() {
        Collections collections = new Collections();
        try {
            try (FileInputStream is = new FileInputStream(FILE);
                 ObjectInputStream ois = new ObjectInputStream(is)) {
                while (is.available() != 0) {
                    collections.add((Film) ois.readObject());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return collections;
    }
}
