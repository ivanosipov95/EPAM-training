package javase02.t02;

import javase02.t02.Stationery.Stationery;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String surname;
    private String position;
    private double salary;
    private List<Stationery> writingMaterials;

    public Employee(String name, String surname, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.surname = surname;
        writingMaterials = new ArrayList<Stationery>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Stationery> getWritingMaterials() {
        return writingMaterials;
    }

    public void setWritingMaterials(List<Stationery> writingMaterials) {
        this.writingMaterials = writingMaterials;
    }

    public void addStationery(Stationery stationery) {
        writingMaterials.add(stationery);
    }

    public double getPriceOfAllStationery() {
        double sum = Double.MIN_VALUE;
        for (Stationery writingMaterial : writingMaterials) {
            sum += writingMaterial.getPrice();
        }
        return sum;
    }
}
