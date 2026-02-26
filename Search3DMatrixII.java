package February;

public class Search3DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1; // Start from top-right

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                col--; // Move left
            }
            else {
                row++; // Move down
            }
        }

        return false;
    }
}
