import math
from typing import List


class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        #
        # Solution v1: MovingAverage
        #
        # This equal to find MovingAverage in order.
        # In other word, smaller element can not affect the average of previous sub
        # Thus, this question is equivalent to finding the maximum substring average
        #
        # Runtime: 840 ms @ (beats) 54.71%
        # Memory Usage: 26 MB @ (beats) 99.55%
        #
        ans = nums[0]
        sub_total = nums[0]

        for i in range(1, len(nums)):
            sub_total += nums[i]
            ans = max(ans, math.ceil(sub_total / (i + 1)))

        return ans


if __name__ == "__main__":
    solution = Solution()

    nums = [3, 7, 1, 6]
    print(f"return: {solution.minimizeArrayValue(nums)}")  # 5

    nums = [10, 1]
    print(f"return: {solution.minimizeArrayValue(nums)}")  # 10

    nums = [6, 9, 3, 8, 14]
    print(f"return: {solution.minimizeArrayValue(nums)}")  # 8
