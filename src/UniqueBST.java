package April;

public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty tree
        dp[1] = 1;  // Single node tree

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                dp[nodes] += dp[left] * dp[right];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBST solution = new UniqueBST();
        int n1 = 3;
        int n2 = 1;
        System.out.println("Input: " + n1 + " -> Output: " + solution.numTrees(n1)); // Output: 5
        System.out.println("Input: " + n2 + " -> Output: " + solution.numTrees(n2)); // Output: 1
    }
}
