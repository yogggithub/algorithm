package top_interview_questions.easy.array;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;

            /*
             * Solution v1: Simplify the problem to compare two adjacent array elements.
             *
             * 200 / 200 test cases passed
             * Runtime: 0 ms @ 100%
             * Memory Usage: 38.8 MB @ 55.56%
             *
             */
            for (int i = 1; i < prices.length; i++) {
                /*
                 * Greedy Algorithm
                 * Calculate every single best movement to achieve largest profit.
                 * If there is a surplus, just take it.
                 */
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;

        }
    }
}
