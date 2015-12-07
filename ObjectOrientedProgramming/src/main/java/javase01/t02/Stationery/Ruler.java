package javase01.t02.Stationery;

public class Ruler extends Stationery {

    private int length;

    public Ruler(String name, double price, int length) {
        this.name = name;
        this.price = price;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
