package June.SumRootToLeaf;

import java.util.Arrays;

public class PalindromePartitioningII {
    public static int minCut(String s) {
        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) pal[i][i] = true;

        // length ≥ 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    pal[i][j] = len == 2 || pal[i + 1][j - 1];
                }
            }
        }

        int[] cuts = new int[n];
        Arrays.fill(cuts, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                cuts[i] = 0;
                continue;
            }

            for (int j = 1; j <= i; j++) {
                if (pal[j][i]) {
                    cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                }
            }
        }

        return cuts[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("ab"));
    }
}
