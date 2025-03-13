package March;

import static java.nio.file.Files.exists;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {  
                if (board[i][j] == wordArr[0] && exists(board, i, j, wordArr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exists(char[][] board, int i, int j, char[] word, int index) {
        // First, check if (i, j) is out of bounds before accessing board[i][j]
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index]) {
            return false;
        }

        // If we reach the last character, return true
        if (index == word.length - 1) {
            return true;
        }

        char ch = board[i][j];
        board[i][j] = '*'; // Mark as visited

        // Move in all four directions: up, down, left, right
        boolean result = exists(board, i + 1, j, word, index + 1) ||  // Down
                exists(board, i - 1, j, word, index + 1) ||  // Up
                exists(board, i, j + 1, word, index + 1) ||  // Right
                exists(board, i, j - 1, word, index + 1);    // Left

        board[i][j] = ch;

        return result;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(arr, word));
    }
}
