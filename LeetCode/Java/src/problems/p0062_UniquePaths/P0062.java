package problems.p0062_UniquePaths;

public class P0062 {
    public int uniquePaths(int m, int n) {
        /*
         * Solution v1: dp array
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 35.8 MB @ (beats) 61.52%
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // base case
                // if there is only one row or col
                // the path is 1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // otherwise, the path should sum up
                    // go right and go down
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];


    }
}
