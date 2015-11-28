package javase01.t06;

/**
 * Данный класс служит для хранения текстового представления записи.
 * @author Ivan Osipov
 * @version 1.0
 */

public class Note {

    /** Свойство запись.*/
    private String note;

    /** Создает новый объект.
     * @param note запись, не null.
     */
    public Note(String note) {
        assert (note != null): "Пустая строка";
        this.note = note;
    }

    /** Получает значение свойства note.
     * @return Возвращает значение записи.
     */
    public String getNote() {
        return note;
    }

    /** Задает новое значение свойства note.
     * @param note запись, не null.
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
}
