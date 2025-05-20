package May;

import java.util.Map;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrices = prices[0];
        int maxPrices = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrices) {

                minPrices = prices[i];
            } else {
                int profit = prices[i] - minPrices;
                maxPrices = Math.max(profit, maxPrices);
            }
        }
        return maxPrices;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));

    }
}
