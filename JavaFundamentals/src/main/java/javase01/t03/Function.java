package javase01.t03;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ivan Osipov
 */

public class Function {

    private double a;
    private double b;
    private double h;
    private Map<Double, Double> table;

    public Function(double a, double b, double h) {
        assert ((a < b) && (h > 0));
        this.a = a;
        this.b = b;
        this.h = h;
        table = new TreeMap<Double, Double>();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setTable(Map<Double, Double> table) {
        this.table = table;
    }

    public Map<Double, Double> getTable() {
        for (double x = a; x <= b ; x += h) {
            table.put(x, Math.tan(2 * x) - 3);
        }
        return table;
    }

    public void print() {
        System.out.println("+---------------------------+");
        System.out.println("|  x  |         f(x)        |");
        System.out.println("+---------------------------+");
        for (Map.Entry entry : table.entrySet()) {
            System.out.printf( "| %.1f | %.16f |\n" , entry.getKey(), entry.getValue());
        }
        System.out.println("+---------------------------+");
    }
}
