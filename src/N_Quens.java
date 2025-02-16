package February;

import java.util.*;

public class N_Quens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(solutions, board, 0, n, cols, diag1, diag2);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, char[][] board, int row, int n,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (char[] r : board) {
                result.add(new String(r));
            }
            solutions.add(result);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(solutions, board, row + 1, n, cols, diag1, diag2);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }

    public static void main(String[] args) {
        N_Quens solver = new N_Quens();
        System.out.println(solver.solveNQueens(4));
    }
}
