package javase01.to2;

/**
 * @author Ivan Osipov
 */

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private double epsilon;
    private int number;
    private List<Double> sequence;

    public Sequence(double epsilon) {
        assert (epsilon > 0):"Значение дожно быть больше 0";
        this.epsilon = epsilon;
        this.number = 1;
        this.sequence = new ArrayList<Double>();
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        assert (epsilon > 0):"Значение дожно быть больше 0";
        this.epsilon = epsilon;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Double> getSequence() {
        return sequence;
    }

    public void setSequence(List<Double> sequence) {
        this.sequence = sequence;
    }

    public int getTheLowestNumber() {
        double element = 0;

        while (true) {
            element = 1 / (Math.pow(number + 1, 2));
            if (element >= epsilon) {
                sequence.add(element);
                number++;
            } else {
                sequence.add(element);
                return number;
            }
        }
    }

    public void printSequence() {
        System.out.println("Последовательность: ");
        for (Double element : sequence) {
            System.out.print("{" + element + "} ");
        }
        System.out.println("\nНаименьший номер эл-та последовательности: " + number);
    }
}