package javase01.t06;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class NotepadTest {

    Notepad expected = new Notepad();
    Note[] notes = new Note[4];

    @Before
    public void setUp() {
        for (int i = 0; i < notes.length; i++) {
            notes[i] = new Note("test");
            expected.add("test");
        }
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < notes.length; i++) {
            assertEquals(notes[i], expected.getNote(i));
        }
    }

    @Test
    public void testRemove() {
        expected.remove(1);
        assertEquals(3, expected.getNotes().length);
    }

    @Test
    public void testChangeNote() {
        expected.changeNote(0, "TEST");
        assertEquals("TEST", expected.getNote(0).toString());
    }
}
