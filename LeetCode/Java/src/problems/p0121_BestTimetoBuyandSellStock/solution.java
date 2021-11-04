package problems.p0121_BestTimetoBuyandSellStock;

public class solution {
    public int maxProfit(int[] prices) {

        // Approach 1: Brute Force
        // 和我自己的遍历一样


        // Approach 2: One Pass
        /*
         * The points of interest are the peaks and valleys in the given graph.
         * We need to find the largest peak following the smallest valley.
         * We can maintain two variables - minprice and maxprofit
         * corresponding to the smallest valley and maximum profit
         * (maximum difference between selling price and minprice)
         * obtained so far respectively.
         *
         * */

        /*
         * 理解：
         * 这是一个单循环
         * 在循环中，找到已查询过的数组中的最小值
         * 并求出当前的最大利润
         *
         * */
        // int minprice = Integer.MAX_VALUE;
        // int maxprofit = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     if (prices[i] < minprice) {
        //         minprice = prices[i];
        //     } else if (prices[i] - minprice > maxprofit) {
        //         maxprofit = prices[i] - minprice;
        //     }
        // }
        // return maxprofit;


        // Approach 3: Kadane's Algorithm
        /*
         * 理解：
         * 单循环，maxCur是每个元素与前一个元素的差，maxSoFar是累计利润
         * 在循环中，求maxCur。若差是负数，则设为0
         * 然后将这个差值不断的累计
         * 并通过比较累计差值与当前差值的较大者，来确定最大利润
         *
         * */
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

    }
}
