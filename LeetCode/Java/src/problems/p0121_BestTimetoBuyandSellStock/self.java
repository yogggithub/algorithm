package problems.p0121_BestTimetoBuyandSellStock;

/*
 * Say you have an array for which the ith element is
 * the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 *  (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 *  profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done,
 * i.e. max profit = 0.
 * */

public class self {
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
