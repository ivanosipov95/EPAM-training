package javase01.t02;

public class Pencil extends Stationery {

    private String type;

    public Pencil(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
