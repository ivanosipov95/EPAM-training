package javase01.t02.Stationery;

public class Lasting extends Stationery {

    private String type;

    public Lasting(String name, double price, String type) {
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
