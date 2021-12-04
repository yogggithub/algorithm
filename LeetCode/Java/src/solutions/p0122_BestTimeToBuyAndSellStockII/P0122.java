package solutions.p0122_BestTimeToBuyAndSellStockII;

public class P0122 {
    public int maxProfit(int[] prices) {
        /*
         * Solution v1: Greedy
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.6 MB @ (beats) 73.87%
         */
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
