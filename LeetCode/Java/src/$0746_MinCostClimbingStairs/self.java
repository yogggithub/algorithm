package $0746_MinCostClimbingStairs;

/*
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 *
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 */

public class self {
    // public static void main(String[] args) {
    //     int[] cost1 = new int[]{10, 15, 20};
    //     int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    //     int[] cost3 = new int[]{1, 2, 3, 1}; // 3
    //     int[] cost4 = new int[]{0, 0, 0, 1}; // 0
    //
    //     self self = new self();
    //     System.out.println(self.minCostClimbingStairs(cost1));
    //     System.out.println(self.minCostClimbingStairs(cost2));
    //     System.out.println(self.minCostClimbingStairs(cost3));
    //     System.out.println(self.minCostClimbingStairs(cost4));
    //
    // }

    public int minCostClimbingStairs(int[] cost) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[cost.length + 1];
        dp[1] = 1;
        dp[2] = 2;

        if (cost.length == 1) {
            return cost[0];
        } else {
            for (int i = 3; i <= cost.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        int[] sum = new int[dp[cost.length]];

        for (int i = 0; i < sum.length - 2; i++) {
            for (int j = 0; j < cost.length; j++) {
                sum[i] = cost[j] + Math.min(sum[i + 1], sum[i + 2]);
            }

            max = max < sum[i] ? max : sum[i];
        }
        return max;
    }
}
