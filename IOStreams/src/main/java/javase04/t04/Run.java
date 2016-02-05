package javase04.t04;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    public static void run() throws IOException {
        Collections films = null;

        if(new File(Collections.FILE).length() == 0) {
            films = new Collections();
        } else {
            films = Collections.restore();
        }

        System.out.println("1 - print\n2 - add\n3 - remove\n4 - exit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;

        while (loop) {
            System.out.println("ente command:");
            String num = reader.readLine();
            switch (num) {
                case "1":
                    if (films.size() == 0 ) {
                        System.out.println("empty list");
                    } else {
                        for (Film film : films) {
                            System.out.println(film);
                        }
                    }
                    break;
                case "2":

                    System.out.println("enter title");
                    String title = reader.readLine();
                    System.out.println("enter the names of actors separated by commas");
                    String names = reader.readLine();
                    String[] namess = names.split(",");
                    Actor[] actors = new Actor[namess.length];
                    for (int i = 0; i < actors.length; i++) {
                        actors[i] = new Actor(namess[i]);
                    }
                    films.add(new Film(title, actors));

                    break;
                case "3":

                    System.out.println("enter title");
                    String titl = reader.readLine();
                    for (Film film : films) {
                        if (film.getTitle().equals(titl)) {
                            films.remove(film);
                        }
                    }

                    break;
                case "4":
                    Collections.save(films);
                    loop = false;
                    break;
                default:
                    System.out.println("incorrect command");
                    break;
            }
        }
    }
}
