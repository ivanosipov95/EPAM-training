package javase01.t06;

/**
 * ������ ����� ������ ��� �������� ���������� ������������� ������.
 * @author Ivan Osipov
 * @version 1.0
 */

public class Note {

    /** �������� ������.*/
    private String note;

    /** ������� ����� ������.
     * @param note ������, �� null.
     */
    public Note(String note) {
        assert (note != null): "������ ������";
        this.note = note;
    }

    /** �������� �������� �������� note.
     * @return ���������� �������� ������.
     */
    public String getNote() {
        return note;
    }

    /** ������ ����� �������� �������� note.
     * @param note ������, �� null.
     */
    public void setNote(String note) {
        assert (note != null): "������ ������";
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
