from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 1069 ms @ (beats) 67.51%
        # Memory Usage: 25.1 MB @ (beats) 32.74%
        #

        ans = 0
        buy = float('inf')

        for p in prices:
            buy = min(buy, p)
            ans = max(ans, p - buy)

        return ans


if __name__ == "__main__":
    solution = Solution()

    prices = [7, 1, 5, 3, 6, 4]
    print(f"return: {solution.maxProfit(prices)}")  # 5

    prices = [7, 6, 4, 3, 1]
    print(f"return: {solution.maxProfit(prices)}")  # 0
