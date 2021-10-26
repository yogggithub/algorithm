package top_interview_questions.easy.dynamic;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        /*
         * Solution v1: Greedy like
         *
         * Runtime: 2 ms @ (beats) 77.71%
         * Memory Usage: 52.3 MB @ (beats) 59.09%
         */

        // this problem is time-order that can not be reversed.
        // we can assume each day is the chance to sell
        // Thus, we can use a variable to store ths minimum value in past
        // and calculate profit for every element
        // find and return the maximum profit
        int profit = 0, buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}
