package October;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = computeLPS(combined);

        int palindromeLength = lps[combined.length() - 1];
        String toAdd = rev.substring(0, s.length() - palindromeLength);
        return toAdd + s;
    }

    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;

        for (int i = 1; i < n; i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("aacecaaa")); // Output: aaacecaaa
        System.out.println(sp.shortestPalindrome("abcd"));     // Output: dcbabcd
    }
}
