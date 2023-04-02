package solutions.p0983_MinimumCostForTickets;

import java.util.Arrays;

public class P0983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];

        int last = days[days.length - 1];
        for (int i = days[0]; i <= last; i++) {
            if (Arrays.binarySearch(days, i) == -1) {
                dp[i] = dp[i - 1];
            } else {
                int pass_1 = dp[Math.max(0, i - 1)] + costs[0];
                int pass_7 = dp[Math.max(0, i - 7)] + costs[1];
                int pass_30 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(Math.min(pass_1, pass_7),
                                 pass_30);

            }
        }
        return dp[last];
    }
}
