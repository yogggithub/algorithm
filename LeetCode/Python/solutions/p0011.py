import math
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:

        #
        # Solution v1: brute force
        #
        # Time Limit Exceeded
        #
        # if len(height) == 2:
        #     return min(i for i in height)
        #
        # max_overall = 0
        #
        # for i in range(len(height)):
        #     if height[i] == 0:
        #         continue
        #
        #     min_length = math.floor(max_overall / height[i])
        #
        #     if min_length > len(height):
        #         continue
        #
        #     max_spot = 0
        #     for j in range(min_length, len(height)):
        #         max_spot = max(max_spot, min(height[i], height[j]) * (j - i))
        #
        #     # print(f"max_spot: {max_spot}")
        #     max_overall = max(max_overall, max_spot)
        #
        # return max_overall

        #
        # Solution v2: two pointer (learned from hint)
        #
        # Runtime: 2058 ms @ (beats) 24.13%
        # Memory Usage: 26.8 MB @ (beats) 90.10%
        #
        # if len(height) == 2:
        #     return min(i for i in height)
        #
        # ans = 0
        #
        # i = 0
        # j = len(height) - 1
        #
        # while i < j:
        #     if height[i] < height[j]:
        #         h = height[i]
        #         i += 1
        #     else:
        #         h = height[j]
        #         j -= 1
        #
        #     ans = max(ans, h * (j - i + 1))
        #
        # return ans

        #
        # Solution v2.1: move pointers faster
        #
        #
        area = 0

        i = 0
        j = len(height) - 1

        while i < j:
            x = min(height[i], height[j])

            temp = (j - i) * x
            if temp >= area:
                area = temp

            if height[i] == x:
                i += 1
                while height[i] < x and i < j:
                    i += 1
            else:
                j -= 1
                while height[j] < x and i < j:
                    j -= 1

        return area


if __name__ == "__main__":
    solution = Solution()

    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(f"return: {solution.maxArea(height)}")
    height = [4, 3, 2, 1, 4]
    print(f"return: {solution.maxArea(height)}")
