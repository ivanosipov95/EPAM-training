package javase01.t02;

import javase01.to2.Sequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest {

    Sequence sequence = new Sequence(0.1);

    @Test
    public void testGetTheLowestNumber() {
        assertEquals(3, sequence.getTheLowestNumber());
    }

    @Test
    public void testPrintSequence() {
        int min = sequence.getTheLowestNumber();
        sequence.printSequence();
    }
}
