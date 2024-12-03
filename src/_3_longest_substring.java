import java.util.HashSet;

public class _3_longest_substring {


    public static int longestSubstring(String s) {
        HashSet<Character> charSet=new HashSet<Character>();
        int left=0;
        int maxLength=0;


        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            charSet.add(s.charAt(right));
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb")); // Output: 3
        System.out.println(longestSubstring("bbbbb"));    // Output: 1
        System.out.println(longestSubstring("pwwkew"));   // Output: 3
    }
}
