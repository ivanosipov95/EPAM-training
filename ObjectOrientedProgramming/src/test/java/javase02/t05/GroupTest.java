package javase02.t05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    Group<Subject> group;

    @Before
    public void setUp() throws Exception {
        group = new Group<>(Subject.MATHEMATICS);

        group.add(new Student("test1", "test1"), 5);
        group.add(new Student("test2", "test2"), 4);
        group.add(new Student("test3", "test3"), 3);
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(3, group.getGroup().size());
    }

    @Test
    public void testGetMark() throws Exception {
      assertEquals("5", group.getMark(new Student("test1", "test1")));
    }
}