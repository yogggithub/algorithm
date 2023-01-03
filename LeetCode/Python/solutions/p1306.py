from typing import List


class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        #
        # Solution v1.1: Recursive
        #
        # the idea should correct
        # but exceed time limitation
        #
        # if len(arr) == 1:
        #     return arr[0] == 0
        #
        # def helper(a: List[int], i: int, isVisited: List[int]) -> bool:
        #     if i in range(len(a)) and i not in isVisited:
        #         left = i - arr[i]
        #         right = i + arr[i]
        #
        #         if left >= 0:
        #             if arr[left] == 0:
        #                 return True
        #         if right < len(a):
        #             if arr[right] == 0:
        #                 return True
        #         isVisited += [i]
        #         return helper(a, left, isVisited) or helper(a, right, isVisited)
        #     else:
        #         return False
        #
        # isVisited = []
        # return helper(arr, start, isVisited)

        #
        # Solution v1.2: Recursive
        #
        # Runtime: 296 ms @ (beats) 73.53%
        # Memory Usage: 61.5 MB @ (beats) 47.66%
        #
        if 0 <= start < len(arr) and arr[start] >= 0:
            # turn the element to negative to mark this already visited
            arr[start] = -arr[start]
            return arr[start] == 0 or \
                   self.canReach(arr, start - arr[start]) or \
                   self.canReach(arr, start + arr[start])
