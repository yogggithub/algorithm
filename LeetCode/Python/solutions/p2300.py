import bisect
import math
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        #
        # Solution v1: Brute Force
        # Time Limit Exceeded
        #
        # ans = [0] * len(spells)
        #
        # for i in range(len(spells)):
        #     gap = math.ceil(success / spells[i])
        #     ans[i] = sum(j >= gap for j in potions)
        #
        # return ans

        #
        # Solution v2: Binary Search
        # Following the Hint, use Binary Search
        #
        # Runtime: 1227 ms @ (beats) 90.93%
        # Memory Usage: 37.4 MB @ (beats) 33.99%
        #
        ans = [0] * len(spells)

        potions.sort()
        m = len(potions)

        for i in range(len(spells)):
            gap = math.ceil(success / spells[i])
            ans[i] = m - bisect.bisect_left(potions, gap)

        return ans


if __name__ == "__main__":
    solution = Solution()

    spells = [5, 1, 3]
    potions = [1, 2, 3, 4, 5]
    success = 7
    print(f"return: {solution.successfulPairs(spells, potions, success)}")  # [4,0,3]

    spells = [3, 1, 2]
    potions = [8, 5, 8]
    success = 16
    print(f"return: {solution.successfulPairs(spells, potions, success)}")  # [2,0,2]
