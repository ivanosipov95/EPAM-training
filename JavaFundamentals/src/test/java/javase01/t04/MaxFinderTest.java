package javase01.t04;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxFinderTest {

    @Test
    public void testGetMax() throws Exception {
        assertEquals(5, new MaxFinder(new double[] {1, 2, -3, 5, 0}).getMax(), 0.1);
    }
}
