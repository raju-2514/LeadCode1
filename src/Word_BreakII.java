package July;

import java.util.*;

public class Word_BreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subSentences = backtrack(s.substring(word.length()), wordSet, memo);
                for (String sub : subSentences) {
                    String sentence = word + (sub.isEmpty() ? "" : " " + sub);
                    result.add(sentence);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Word_BreakII solver = new Word_BreakII();

        String s1 = "catsanddog";
        List<String> dict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(solver.wordBreak(s1, dict1));

        String s2 = "pineapplepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(solver.wordBreak(s2, dict2));

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solver.wordBreak(s3, dict3));
    }
}
