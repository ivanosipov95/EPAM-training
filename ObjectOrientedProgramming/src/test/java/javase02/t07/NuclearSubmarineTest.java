package javase02.t07;

import org.junit.Test;

public class NuclearSubmarineTest {

    @Test
    public void testAnnotation() {
        Class<?> submarine = NuclearSubmarine.class;
        if (submarine.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ann = submarine.getAnnotation(MyAnnotation.class);
            System.out.println(ann.annotationType());
            System.out.format("%s %s %s",ann.author(), ann.date(), ann.version());
        }
    }
}