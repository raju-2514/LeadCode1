package August;

public class DungeonGames {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] means the minimum HP needed to reach the goal from cell (i, j)
        int[][] dp = new int[m][n];

        // Start from the princess's cell (bottom-right)
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Fill last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        // Fill last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        // Fill the rest of the dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthNeeded - dungeon[i][j]);
            }
        }

        return dp[0][0]; // Minimum HP needed at start
    }

    // Example usage
    public static void main(String[] args) {
        DungeonGames solver = new DungeonGames();

        int[][] dungeon1 = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println("Output: " + solver.calculateMinimumHP(dungeon1)); // Output: 7

        int[][] dungeon2 = {{0}};
        System.out.println("Output: " + solver.calculateMinimumHP(dungeon2)); // Output: 1
    }
}
