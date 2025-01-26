package January;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // Initialize sets for rows, columns, and sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + c / 3;

                    if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    
                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
