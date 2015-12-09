package javase02.t05;

import java.util.HashMap;
import java.util.Map;

public class Group <T extends Subject> {

    private T subject;
    private Map<Student, Number> group;

    public Group(T subject) {
        this.subject = subject;
        group = new HashMap<>();
    }

    public T getSubject() {
        return subject;
    }

    public Map<Student, Number> getGroup() {
        return group;
    }

    public void add(Student student, Number mark) {
        group.put(student, subject.set(mark));
    }

    public String getMark(Student student) {
        if (group.containsKey(student)) {
            return group.get(student).toString();
        }
        return "Студент не найден!";
    }
}
