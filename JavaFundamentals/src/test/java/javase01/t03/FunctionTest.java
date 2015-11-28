package javase01.t03;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class FunctionTest {

    private Function f = new Function(2, 4, 1);
    private Map<Double, Double> actual = f.getTable();
    private Map<Double, Double> expected = new TreeMap<Double, Double>();
    private static final double F_TWO = -1.8421787176504223;
    private static final double F_TREE = -3.2910061913847493;
    private static final double F_FOUR = -9.799711455220379;

    @Before
    public void setUp() {
        expected.put(2.0, F_TWO);
        expected.put(3.0, F_TREE);
        expected.put(4.0, F_FOUR);
    }

    @Test
    public void testGetTable() {
        assertEquals(expected, actual);
    }

    @Test
    public void testPrint() {
        f.print();
    }
}
