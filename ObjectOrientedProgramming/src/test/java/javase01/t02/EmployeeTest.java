package javase01.t02;

import javase01.t02.Stationery.Pen;
import javase01.t02.Stationery.Pencil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("test", "test", 20000, "test");
        employee.addStationery(new Pen("pen", 48,"gel", "black"));
        employee.addStationery(new Pencil("pencil", 20, "soft"));
    }

    @Test
    public void testAddStationery() {
        assertEquals(2, employee.getWritingMaterials().size());
    }

    @Test
    public void testGetPriceOfAllStationery() {
        assertEquals(68, employee.getPriceOfAllStationery(), 0.1);
    }
}
