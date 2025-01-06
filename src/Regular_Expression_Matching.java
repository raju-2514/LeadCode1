package January;

public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* that can match an empty string
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // match zero occurrence of the character before *
            }
        }

        // Fill dp table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    // If characters match or pattern is '.', carry over previous match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // If we encounter '*', we have two possibilities:
                    // 1. Match zero occurrence of the character before '*'
                    // 2. Match one or more occurrences of the character before '*'
                    dp[i][j] = dp[i][j - 2] || (matches(sc, p.charAt(j - 2)) && dp[i - 1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    // Helper function to check if a character matches a pattern character
    private boolean matches(char sChar, char pChar) {
        return pChar == sChar || pChar == '.';
    }
    public static void main(String[] args) {
         Regular_Expression_Matching r = new Regular_Expression_Matching();
         System.out.println(r.isMatch("aa", "a"));
         System.out.println(r.isMatch("aa", "a"));
         System.out.println(r.isMatch("aa", "a*"));
         System.out.println(r.isMatch("aa", "a*"));
         System.out.println(r.isMatch("aa", "a*b"));
       

    }
}
