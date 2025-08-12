package August;

public class StockProfitKTransactions {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // If k >= n/2, then we can just do unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        StockProfitKTransactions solver = new StockProfitKTransactions();
        System.out.println(solver.maxProfit(2, new int[]{2,4,1}));        // 2
        System.out.println(solver.maxProfit(2, new int[]{3,2,6,5,0,3})); // 7
    }
}
