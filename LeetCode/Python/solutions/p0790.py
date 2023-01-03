class Solution:
    def numTilings(self, n: int) -> int:
        #
        # Solution v1: dynamic programming
        #
        # Runtime: ms @ (beats) %
        # Memory Usage: MB @ (beats) %
        #

        # idea:
        # for a given n, there are three ways to construct:
        # 1. n - 1 + { | }
        # 2. n - 2 + { || or = }.
        # pay attention here, || is already include in n - 1
        # thus, there is only one way to translate from n - 2
        # 3. for any num <= n - 3, there are two ways, end with either < or >
        # thus, dp[n] = dp[n-1] + dp[n-2] + 2 * (dp[n-3] + ... +dp[1])
        #             = dp[n-1] + dp[n-3] + (dp[n-2] + dp[n-3] + 2 * (dp[n-4] + ... + dp[1])
        #             = dp[n-1] + dp[n-3] + dp[n-1]
        #             = 2 * dp[n-1] + dp[n-3]

        # to optimize memory, only declare variables without storing temp values
        if n == 1:
            return 1
        elif n == 2:
            return 2
        elif n == 3:
            return 5
        else:
            MOD = int(1e9 + 7)
            dp1 = 1
            dp2 = 2
            dp3 = 5
            for i in range(4, n + 1):
                dp4 = 2 * dp3 + dp1
                dp1 = dp2
                dp2 = dp3
                dp3 = dp4
            return dp4 % MOD
