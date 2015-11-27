package javase01.t05;

/**
 * @author Ivan Osipov
 */

public class Matrix {

    private int[][] matrix;

    public Matrix(int n) {
        assert (n > 0);
        matrix = new int[n][n];
    }

    public int[][] getMatrixWithUnitsOnDiagonals() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if ((i + j) == (matrix.length - 1)) {
                    matrix[i][j] = 1;
                }
            }
        }
       return matrix;
    }
}
