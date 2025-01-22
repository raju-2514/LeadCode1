package January;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_With_The_All_Word {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        // Get the length of each word and the total length of concatenated substring
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;

        // Create a frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Traverse the string using a sliding window
        for (int i = 0; i <= s.length() - totalWordsLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                // Get the current word
                int startIndex = i + j * wordLength;
                String word = s.substring(startIndex, startIndex + wordLength);

                // If the word is not in the original list, break
                if (!wordCount.containsKey(word)) {
                    break;
                }

                // Add the word to the seen map
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                // If the count exceeds the original frequency, break
                if (seenWords.get(word) > wordCount.get(word)) {
                    break;
                }

                j++;
            }

            // If all words are matched, add the starting index
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println(findSubstring(s1, words1));
    }
}
