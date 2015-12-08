package javase02.t03;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeginnerSetTest {

    @Test
    public void testFill() {
        assertEquals(5, new BeginnerSet().getBeginnerSet().size());
    }
}
