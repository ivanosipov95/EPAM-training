package javase01.t05;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private int[][] matrix = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {1, 0, 0, 1},
    };

    @Test
    public void testGetMatrixWithUnitsOnDiagonals() {
        int[][] m = new Matrix(4).getMatrixWithUnitsOnDiagonals();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                assertEquals(matrix[i][j], m[i][j]);
            }
        }
    }
}
