package February;

public class MinimumPathSum {
    public int minPathSum(int[][] grid){
          int m=grid.length;
          int n=grid[0].length;

          int[][] dp=new int[m][n];
          dp[0][0]=grid[0][0];

          for(int i=1;i<n;i++){
              dp[0][i] = dp[0][i - 1] + grid[0][i];
          }

        // Fill the first column (can only come from above)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the bottom-right corner as the result
        return dp[m - 1][n - 1];


    }
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(grid1));
    }
}
