package April;

public class Decodes_Ways {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty string has 1 way to decode
        dp[1] = 1; // First character is valid and not '0'

        for (int i = 2; i <= n; i++) {
            // One digit check (current char)
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digits check (previous + current char)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));    // Output: 2
        System.out.println(numDecodings("226"));   // Output: 3
        System.out.println(numDecodings("06"));    // Output: 0
        System.out.println(numDecodings("11106")); // Output: 2
    }

}
