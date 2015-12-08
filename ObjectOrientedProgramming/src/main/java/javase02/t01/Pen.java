package javase02.t01;

import java.util.Objects;

public class Pen {

    private double price;
    private String mark;
    private String type;
    private String color;

    public Pen(int price, String mark, String type, String color) {
        this.price = price;
        this.mark = mark;
        this.type = type;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(price, pen.price) &&
                Objects.equals(mark, pen.mark) &&
                Objects.equals(type, pen.type) &&
                Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, type, color);
    }

    @Override
    public String toString() {
        return "Pen {" +
                "price=" + price +
                ", mark='" + mark + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
