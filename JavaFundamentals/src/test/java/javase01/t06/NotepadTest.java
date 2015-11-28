package javase01.t06;

import org.junit.Test;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class NotepadTest {

    private Notepad expected = new Notepad();
    private Notepad actual =new Notepad();
    private List<Note> notes = new LinkedList<Note>();

    @Before
    public void setUp() {
        notes.add(new Note("test"));
        expected.setNotes(notes);
    }

    @Test
    public void testAdd() {
        actual.add("test");
        assertEquals(expected.getNotes(), actual.getNotes());
    }

    @Test
    public void testRemoveByIndex() {
        notes.remove(0);
        expected.setNotes(notes);

        actual.remove(0);
        assertEquals(expected.getNotes(), actual.getNotes());
    }

    @Test
    public void testRemove() {
        notes.remove(0);
        expected.setNotes(notes);

        actual.add("test");
        actual.remove(new Note("test"));

        assertEquals(expected.getNotes(), actual.getNotes());
    }

    @Test
    public void testChangeNote() {
        actual.add("test");
        actual.changeNote(0, "new test");

        assertEquals("new test", actual.getAll().get(0).getNote());
    }
}
