package javase01.t06;

import java.util.Arrays;

/**
 * ������ ����� ������ ��� �������� �������.
 * @author Ivan Osipov
 * @version 2.0
 */

public class Notepad {

    /**
     * ����������� �������� �� ���������.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * ������ ������� ���� Note.
     */
    private Note[] notes;

    /**
     * ���-�� ������� � ��������.
     */
    private int index;

    /**
     * ����������� � �����������.
     * @param initialCapacity ������ �������� ������ ���� ������ 0.
     */
    public Notepad(int initialCapacity) {
        assert (initialCapacity > 0);
        notes = new Note[initialCapacity];
    }

    /**
     * ����������� �� ���������.
     * ������ �������� ��������������� �� ��������� (16).
     */
    public Notepad() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * ���������� ������ � �������� ��������.
     * @param i ������ ������ � ��������.
     * @return ������ � �������� ��������.
     */
    public Note getNote(int i) {
        assert ((i >= 0) && (i < index));

        return notes[i];
    }

    /**
     * ���������� ������ ������� ���� Note.
     * @return ������ ������� ���� Note.
     */
    public Note[] getNotes() {
        return Arrays.copyOf(notes, index);
    }

    /**
     * ��������� ����� ������ � �������.
     * @param text ��������� ������������� ������.
     */
    public void add(String text) {
        Note note = new Note(text);
        if (isPossibleToAdd()) {
            notes[index++] = note;
        } else {
            grow();
            notes[index++] = note;
        }
    }

    /**
     * ������� ������ � ��������.
     * @param i ������ ������ ���� ������ 0 � ������ ����������� ��������.
     */
    public void remove(int i) {
        assert ((i >= 0) && (i < index));

        int numMoved = notes.length - i - 1;
        if (numMoved > 0) {
            System.arraycopy(notes, i + 1, notes, i, numMoved);
        }

        notes = Arrays.copyOf(notes, notes.length - 1);
        --index;
    }

    /**
     * �������� ������ � �������� �������� � ��������.
     * @param i ������ ������ ���� ������ 0 � ������ ����������� ��������.
     * @param note ��������� ������������� ������.
     */
    public void changeNote(int i, String note) {
        assert ((i >= 0) && (i < index));

        notes[i].setNote(note);
    }

    private boolean isPossibleToAdd() {
        return ((index < notes.length) && (index < Integer.MAX_VALUE));
    }

    private void grow() {
        int capacity = notes.length << 1;

        if (capacity - index < 0) {
            capacity = Integer.MAX_VALUE;
        }
        notes = Arrays.copyOf(notes, capacity);
    }
}
