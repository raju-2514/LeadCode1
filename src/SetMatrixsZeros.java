package March;
import java.util.*;
public class SetMatrixsZeros {
        public static void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean firstRowZero = false, firstColZero = false;

            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) firstColZero = true;
            }

            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) firstRowZero = true;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstColZero) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }

            if (firstRowZero) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
        }

        public static void main(String[] args) {
            int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
            setZeroes(matrix1);
            System.out.println(Arrays.deepToString(matrix1)); // Output: [[1,0,1],[0,0,0],[1,0,1]]

            int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
            setZeroes(matrix2);
            System.out.println(Arrays.deepToString(matrix2)); // Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        }
}

