package javase01.t06;

import java.util.Arrays;

/**
 * Данный класс служит для хранения записей.
 * @author Ivan Osipov
 * @version 2.0
 */

public class Notepad {

    /**
     * Размерность блокнота по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Массив записей типа Note.
     */
    private Note[] notes;

    /**
     * Кол-во записей в блокноте.
     */
    private int index;

    /**
     * Конструктор с параметрами.
     * @param initialCapacity размер блокнота должен быть больше 0.
     */
    public Notepad(int initialCapacity) {
        assert (initialCapacity > 0);
        notes = new Note[initialCapacity];
    }

    /**
     * Конструктор по умолчанию.
     * Размер блокнота устанавливается по умолчанию (16).
     */
    public Notepad() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Возвращает запись с заданным индексом.
     * @param i индекс записи в блокноте.
     * @return запись с заданным индексом.
     */
    public Note getNote(int i) {
        assert ((i >= 0) && (i < index));

        return notes[i];
    }

    /**
     * Возвращает массив записей типа Note.
     * @return массив записей типа Note.
     */
    public Note[] getNotes() {
        return Arrays.copyOf(notes, index);
    }

    /**
     * Добавляет новую запись в блокнот.
     * @param text текстовое представление записи.
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
     * Удаляет запись в блокноте.
     * @param i индекс должен быть больше 0 и меньше размерности блокнота.
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
     * Изменяет запись с заданным индексом в блокноте.
     * @param i индекс должен быть больше 0 и меньше размерности блокнота.
     * @param note текстовое представление записи.
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
