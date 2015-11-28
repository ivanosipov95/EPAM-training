package javase01.t06;

import java.util.LinkedList;
import java.util.List;

/**
 * ƒанный класс служит дл€ хранени€ записей в блокноте.
 * @author Ivan Osipov
 * @version 1.0
 */

public class Notepad {

    /** —войство - записи.*/
    private List<Note> notes;

    /** —оздает новый объект и инициализирует поле {@link Notepad#notes}.*/
    public Notepad() {
        notes = new LinkedList<Note>();
    }

    /** ѕолучает значение свойства notes.
     * @return ¬озвращает записи в блокноте.
     */
    public List<Note> getNotes() {
        return notes;
    }

    /** «адает новое значение свойства note.
     * @param notes записи.
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /** ƒобавл€ет новую запись в блокнот.
     * @param note текстовое представление записи.
     */
    public void add(String note) {
        notes.add(new Note(note));
    }

    /** ”дал€ет запись в блокноте.
     * @param i индекс, должен быть больше 0 и меньше размерности блокнота.
     */
    public void remove(int i) {
        assert ((i >= 0) && ((i - 1) < notes.size()));
        for (int j = 0; j < notes.size(); j++) {
            if (i == j) {
                notes.remove(i);
                break;
            }
        }
    }

    /** ”дал€ет запись в блокноте.
     * @param note объект типа Note.
     */
    public void remove(Note note) {
        for (Note n : notes) {
            if (n.equals(note)) {
                notes.remove(note);
                break;
            }
        }
    }

    /** »змен€ет выбранную запись в блокноте.
     * @param i индекс, должен быть больше 0 и меньше размерности блокнота.
     * @param note текстовое представление записи.
     */
    public void changeNote(int i, String note) {
        assert ((i >= 0) && ((i - 1) < notes.size()));
        for (int j = 0; j < notes.size(); j++) {
            if (i == j) {
                notes.get(i).setNote(note);
                break;
            }
        }
    }

    /** ѕолучает значение свойства notes.
     * @return ¬озвращает все записи в блокноте.
     */
    public List<Note> getAll() {
        return notes;
    }
}
