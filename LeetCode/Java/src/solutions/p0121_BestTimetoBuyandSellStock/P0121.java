package solutions.p0121_BestTimetoBuyandSellStock;

public class P0121 {
    public int maxProfit(int[] prices) {

        // Brute Force
        // int max = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         int profit = prices[j] - prices[i];
        //         if (max < profit) {
        //             max = profit;
        //         }
        //     }
        // }
        // return max;

        // Runtime: 201 ms, faster than 6.83% of Java online submissions for Best Time to Buy and Sell Stock.
        // Memory Usage: 38.7 MB, less than 46.02% of Java online submissions for Best Time to Buy and Sell Stock.


        // 多加一步判断，但为什么更慢了？
        int max = 0, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    profit = prices[j] - prices[i];
                }
                if (max < profit) {
                    max = profit;
                }
            }
        }
        return max;

        // Runtime: 347 ms, faster than 5.02% of Java online submissions for Best Time to Buy and Sell Stock.
        // Memory Usage: 38.8 MB, less than 30.53% of Java online submissions for Best Time to Buy and Sell Stock.
    }
}
