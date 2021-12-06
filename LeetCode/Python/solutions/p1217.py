from typing import List


class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 32 ms @ (beats) 72.22%
        # Memory Usage: 14.3 MB @ (beats) 51.28%
        #

        # idea:
        # cost 0 for moving two step
        # means should consider chip in two groups: odd or even
        # find which group has less amount
        # then the cost should be 1 * the other
        odd = even = 0

        for i in position:
            if i % 2 == 0:
                even += 1
            else:
                odd += 1

        return min(odd, even)
