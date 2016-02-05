package javase03.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleWork {

    private ResourceBundle questions;
    private ResourceBundle answers;


    public void setLocale(Locale locale) {
        int n = 0;
        questions = ResourceBundle.getBundle("questions", locale);
        answers = ResourceBundle.getBundle("answers", locale);

        Enumeration<String> keys = questions.getKeys();

        while (keys.hasMoreElements()) {
            System.out.println(++n + "." + questions.getString(keys.nextElement()));
        }
    }

    public void getAnswer(int n) {
        System.out.println(answers.getString("n" + n));
    }

    public void run() throws IOException {
        System.out.println("1.Russian\n2.English");
        System.out.println("select language");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        switch (num) {
            case 1: {
                setLocale(new Locale("ru", "RU"));
                break;
            }
            case 2: {
                setLocale(new Locale("en", "US"));
                break;
            }
            default:
                System.out.println("incorrect command");
                break;
        }
        System.out.println("select question");
        getAnswer(Integer.parseInt(reader.readLine()));
    }
}
