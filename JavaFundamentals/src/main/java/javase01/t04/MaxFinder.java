package javase01.t04;

/**
 * @author Ivan Osipov
 */
public class MaxFinder {

    private double[] array;

    public MaxFinder(double[] array) {
        this.array = array;
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public double getMax() {
        double max = array[0] + array[1];
        double temp = max;
        for (int i = 0; i < array.length - 1; i++) {
            temp = array[i] + array[i + 1];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}