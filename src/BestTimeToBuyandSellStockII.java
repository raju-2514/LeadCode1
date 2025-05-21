package May;

public class BestTimeToBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If selling today is profitable, do it
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyandSellStockII sp = new BestTimeToBuyandSellStockII();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Profit: " + sp.maxProfit(prices1)); // Output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Profit: " + sp.maxProfit(prices2)); // Output: 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Profit: " + sp.maxProfit(prices3)); // Output: 0
    }
}
