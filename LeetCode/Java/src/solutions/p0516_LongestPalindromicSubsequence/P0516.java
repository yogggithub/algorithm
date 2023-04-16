package solutions.p0516_LongestPalindromicSubsequence;

public class P0516 {
    public int longestPalindromeSubseq(String s) {
        /*
         * Solution v1: Dynamic Programming
         *
         * Runtime: 39 ms @ (beats) 83.77%
         * Memory Usage: 42.7 MB @ (beats) 95.11%
         */
        int l = s.length();
        int[] dp = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            int[] curr = new int[l];
            curr[i] = 1;
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    curr[j] = 2 + dp[j - 1];
                } else {
                    curr[j] = Math.max(dp[j], curr[j - 1]);
                }
            }
            dp = curr;
        }
        return dp[l - 1];

    }
}
