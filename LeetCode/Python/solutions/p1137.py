class Solution:
    def tribonacci(self, n: int) -> int:
        #
        # Solution v1: Brute Force Recursive
        #
        # Time Limit Exceeded when n >= 30
        #

        # if n == 0:
        #     return 0
        # elif n == 1:
        #     return 1
        # elif n == 2:
        #     return 1
        # else:
        #     return self.tribonacci(n - 1) + self.tribonacci(n - 2) + self.tribonacci(n - 3)

        #
        # Solution v2: DP
        #
        # Runtime: 23 ms @ (beats) 97.51%
        # Memory Usage: 13.8 MB @ (beats) 54.1%
        #

        dp = [0, 1, 1]

        for i in range(3, n + 1):
            dp.append(dp[i - 1] + dp[i - 2] + dp[i - 3])

        return dp[n]

        #
        # Solution v2.1: Assign instead of Insert
        #
        # Runtime: 26 ms @ (beats) 92.94%
        # Memory Usage: 13.9 MB @ (beats) 54.1%
        #

        # if n == 0:
        #     return 0
        # if n == 1:
        #     return 1
        # if n == 2:
        #     return 1
        # dp = [0] * (n + 1)
        #
        # dp[0] = 0
        # dp[1] = 1
        # dp[2] = 1
        #
        # for i in range(3, n + 1):
        #     dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        #
        # return dp[n]


if __name__ == "__main__":
    solution = Solution()

    n = 4
    print(f"return: {solution.tribonacci(4)}")  # 4

    n = 25
    print(f"return: {solution.tribonacci(25)}")  # 1389537
