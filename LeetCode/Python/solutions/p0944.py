from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:

        #
        # Solution v1: brute force
        #
        # Runtime: 177 ms @ (beats) 72.42%
        # Memory Usage: 14.6 MB @ (beats) 93.5%
        #

        d = 0
        if len(strs) > 1:
            n = len(strs)
            l = len(strs[0])

            for j in range(l):
                # for i in range(n):
                #     if i > 0:
                #         if strs[i][j] < strs[i - 1][j]:
                #             d += 1
                #             break

                # a little improvement
                for i in range(1, n):
                    if strs[i][j] < strs[i - 1][j]:
                        d += 1
                        break

        return d

        #
        # Solution v2: built-in zip() function
        #
        #
        c = 0
        for i in zip(*strs):
            if list(i) != sorted(i):
                c += 1
        return c
