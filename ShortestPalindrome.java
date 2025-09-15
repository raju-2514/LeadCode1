package September;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPS(combined);

        // longest palindrome prefix length
        int longestPrefix = lps[combined.length() - 1];

        // suffix to add in front
        String suffix = s.substring(longestPrefix);
        String prefixToAdd = new StringBuilder(suffix).reverse().toString();

        return prefixToAdd + s;
    }

    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix suffix

        for (int i = 1; i < n; ) {
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
