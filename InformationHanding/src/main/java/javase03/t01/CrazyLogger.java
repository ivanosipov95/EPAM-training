package javase03.t01;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {
    private StringBuilder log;

    public CrazyLogger() {
        log = new StringBuilder();
    }

    public StringBuilder getLog() {
        return log;
    }

    public void setLog(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm");
        LocalDateTime time = LocalDateTime.now();

        String timeFormat = time.format(formatter);
        log.append(timeFormat + " - " + message + "\n");
    }

    public String search(String message) {
        String[] logs = log.toString().split("\n");

        for (String s : logs) {
            if (s.contains(message)) {
                return s;
            }
        }

        return "not found!";
    }
}
