package solutions.p0746_MinCostClimbingStairs;

public class solution {
    public static void main(String[] args) {
        solution solution = new solution();

        int[] cost1 = new int[]{10, 15, 20};
        int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}; // 6
        int[] cost3 = new int[]{1, 2, 3, 100, 0, 100}; // 3
        int[] cost4 = new int[]{0, 0, 0, 1}; // 0

        // System.out.println(solution.minCostClimbingStairs(cost1));
        // System.out.println(solution.minCostClimbingStairs(cost2));
        System.out.println(solution.minCostClimbingStairs(cost3));
        // System.out.println(solution.minCostClimbingStairs(cost4));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int f0 = cost[0], f1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int f_current = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = f_current;
        }
        return Math.min(f0, f1);

        /*
         * 思路：
         * 1. 逐个考虑每个位置的最优解，应该是：当前位置，加上前1个或前2个中的最小值
         * 2. 不断更新前1个、前2个位置的最优解，以最小值向后迭代
         * 3. 不用考虑路线问题，只要每个位置是最小解，最终结果就是最优的
         *
         */
    }
}
