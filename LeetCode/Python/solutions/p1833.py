from typing import List


class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:

        costs.sort()

        #
        # Solution v1: brute force
        #
        # Runtime: 1565 ms @ (beats) 43.72%
        # Memory Usage: 28.1 MB @ (beats) 17.54%
        #
        # ans = 0
        #
        # for c in costs:
        #     coins -= c
        #     if coins < 0:
        #         return ans
        #
        #     ans += 1
        #
        # return ans

        #
        # Solution v1.5: use index directly
        #
        #
        for i in range(len(costs)):
            coins -= costs[i]
            if coins < 0:
                return i
        return i + 1
