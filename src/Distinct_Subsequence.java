package May;

public class Distinct_Subsequence {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] = number of distinct subsequences of s[0..i-1] that equals t[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // An empty t can be matched by any prefix of s in exactly one way (by deleting all characters)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Use the character or skip it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Skip the character in s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Distinct_Subsequence solver = new Distinct_Subsequence();

        String s1 = "rabbbit", t1 = "rabbit";
        System.out.println("Output: " + solver.numDistinct(s1, t1)); // Output: 3

        String s2 = "babgbag", t2 = "bag";
        System.out.println("Output: " + solver.numDistinct(s2, t2)); // Output: 5
    }
}
