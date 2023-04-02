from typing import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        #
        # Solution v1: Dynamic Programming
        #
        # Runtime: 61 ms @ (beats) 20.46%
        # Memory Usage: 13.8 MB @ (beats) 99.34%
        #
        # dp = [0] * 366
        # for i in range(1, 366):
        #     if i in days:
        #         dp[i] = min(dp[i - 1] + costs[0],
        #                     # 7-day pass, but keep index positive
        #                     dp[max(0, i - 7)] + costs[1],
        #                     # 30-day pass, but keep index positive
        #                     dp[max(0, i - 30)] + costs[-1])
        #     else:
        #         dp[i] = dp[i - 1]
        #
        # return dp[-1]

        #
        # Solution v1.1: Dynamic Programming
        # Narrow iterative range
        #
        # Runtime: 51 ms @ (beats) 47.19%
        # Memory Usage: 13.9 MB @ (beats) 83.75%
        #
        dp = [0] * 366
        for i in range(days[0], days[-1] + 1):
            if i in days:
                dp[i] = min(dp[i - 1] + costs[0],
                            # 7-day pass, but keep index positive
                            dp[max(0, i - 7)] + costs[1],
                            # 30-day pass, but keep index positive
                            dp[max(0, i - 30)] + costs[-1])
            else:
                dp[i] = dp[i - 1]

        return dp[days[-1]]


if __name__ == "__main__":
    solution = Solution()

    days = [1, 4, 6, 7, 8, 20]
    costs = [2, 7, 15]
    print(f"return: {solution.mincostTickets(days, costs)}")  # 11

    days = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]
    costs = [2, 7, 15]
    print(f"return: {solution.mincostTickets(days, costs)}")  # 17
