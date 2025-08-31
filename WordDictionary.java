package August;

public class WordDictionary {
    private TrieNode root;

    // TrieNode class
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // Constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word to Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // Search with '.' support
    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node) {
        if (node == null) return false;

        // If we reached the end of the word
        if (index == word.length()) return node.isEnd;

        char ch = word.charAt(index);

        if (ch == '.') {
            // Try all possibilities
            for (TrieNode child : node.children) {
                if (child != null && dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int i = ch - 'a';
            return dfsSearch(word, index + 1, node.children[i]);
        }
    }

    // Test
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}
