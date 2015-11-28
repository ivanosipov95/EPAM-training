package javase01.t06;

import java.util.LinkedList;
import java.util.List;

/**
 * ������ ����� ������ ��� �������� ������� � ��������.
 * @author Ivan Osipov
 * @version 1.0
 */

public class Notepad {

    /** �������� - ������.*/
    private List<Note> notes;

    /** ������� ����� ������ � �������������� ���� {@link Notepad#notes}.*/
    public Notepad() {
        notes = new LinkedList<Note>();
    }

    /** �������� �������� �������� notes.
     * @return ���������� ������ � ��������.
     */
    public List<Note> getNotes() {
        return notes;
    }

    /** ������ ����� �������� �������� note.
     * @param notes ������.
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /** ��������� ����� ������ � �������.
     * @param note ��������� ������������� ������.
     */
    public void add(String note) {
        notes.add(new Note(note));
    }

    /** ������� ������ � ��������.
     * @param i ������, ������ ���� ������ 0 � ������ ����������� ��������.
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

    /** ������� ������ � ��������.
     * @param note ������ ���� Note.
     */
    public void remove(Note note) {
        for (Note n : notes) {
            if (n.equals(note)) {
                notes.remove(note);
                break;
            }
        }
    }

    /** �������� ��������� ������ � ��������.
     * @param i ������, ������ ���� ������ 0 � ������ ����������� ��������.
     * @param note ��������� ������������� ������.
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

    /** �������� �������� �������� notes.
     * @return ���������� ��� ������ � ��������.
     */
    public List<Note> getAll() {
        return notes;
    }
}
