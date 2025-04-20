package April;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InterLeavingString {
    public boolean isinterleaving(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return solve(0, 0, s1, s2, s3,dp) == 1;
    }


    private int solve(int i, int j, String s1, String s2, String s3,int[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return 1;
        }


        if(dp[i][j]!=-1) return dp[i][j];

        if (i < s1.length() && i + j < s3.length() && s1.charAt(i) == s3.charAt(i + j) &&
                solve(i + 1, j, s1, s2, s3,dp) == 1) {
            return dp[i][j]=1;
        }

        if (j < s2.length() && i + j < s3.length() && s2.charAt(j) == s3.charAt(i + j) &&
                solve(i, j + 1, s1, s2, s3,dp) == 1) {
            return dp[i][j]=1;
        }

        return 0;


    }

    public static void main(String[] args) {
        InterLeavingString s = new InterLeavingString();

        System.out.println(s.isinterleaving("aabcc", "dbbca", "aadbbcbcac"));
    }
}


//
//public boolean isInterleave(String s1, String s2, String s3) {
//    int m = s1.length();
//    int n = s2.length();
//
//    if (s3.length() != m + n) return false;
//
//    boolean[][] dp = new boolean[m + 1][n + 1];
//    dp[0][0] = true;
//
//    // Fill first column
//    for (int i = 1; i <= m; i++) {
//        dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
//    }
//
//    // Fill first row
//    for (int j = 1; j <= n; j++) {
//        dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
//    }
//
//    // Fill the rest of the table
//    for (int i = 1; i <= m; i++) {
//        for (int j = 1; j <= n; j++) {
//            dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
//                    (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
//        }
//    }
//
//    return dp[m][n];
//}