class Solution:
    def climbStairs(self, n: int) -> int:
        #
        # Solution v1: dynamic process
        #
        # Runtime: 24 ms @ (beats) 95.12%
        # Memory Usage: 14.2 MB @ (beats) 44.63%
        #
        dp = [0, 1, 2, 3]  # extra dummy element for n=0
        for i in range(4, n + 1):
            dp.append(dp[i - 1] + dp[i - 2])

        return dp[n]
