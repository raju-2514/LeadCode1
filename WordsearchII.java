package September;

import java.util.ArrayList;
import java.util.List;

public class WordsearchII {
    // TrieNode definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // store the full word at the end node
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // mark the end of a word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#'; // mark as visited

        // explore neighbors
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        board[i][j] = c; // restore after backtracking
    }

    public static void main(String[] args) {
        WordsearchII solver = new WordsearchII();

        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words1 = {"oath","pea","eat","rain"};
        System.out.println(solver.findWords(board1, words1)); // [oath, eat]

        char[][] board2 = {
                {'a','b'},
                {'c','d'}
        };
        String[] words2 = {"abcb"};
        System.out.println(solver.findWords(board2, words2)); // []
    }
}
