package February;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // First, transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Second, reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        RotateImage sol = new RotateImage();
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        sol.rotate(matrix1);
        System.out.println("Rotated Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        sol.rotate(matrix2);
        System.out.println("Rotated Matrix 2:");
        printMatrix(matrix2);
    }
}
