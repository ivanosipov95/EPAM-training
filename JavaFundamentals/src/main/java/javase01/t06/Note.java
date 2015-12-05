package javase01.t06;

/**
 * Данный класс служит для хранения текстового представления записи.
 * @author Ivan Osipov
 * @version 2.0
 */

public class Note {

    /**Поле запись.*/
    private String note;

    /**
     * Конструктор с параметрами.
     * @param note запись не должна быть null.
     */
    public Note(String note) {
        assert (note != null): "Пустая строка";
        this.note = note;
    }

    /**
     * Возвращает значение поля note.
     * @return Возвращает значение записи.
     */
    public String getNote() {
        return note;
    }

    /**
     * Задает новое значение свойства note.
     * @param note запись не должна быть null.
     */
    public void setNote(String note) {
        assert (note != null): "Пустая строка";
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note1 = (Note) o;

        return !(note != null ? !note.equals(note1.note) : note1.note != null);

    }

    @Override
    public int hashCode() {
        return note != null ? note.hashCode() : 0;
    }

    @Override
    public String toString() {
        return note;
    }
}


