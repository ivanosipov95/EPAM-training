package javase01.t02;

public class Pen extends Stationery {

    private String type;
    private String color;

    public Pen(String name, double price, String type, String color) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
