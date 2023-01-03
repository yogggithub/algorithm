from ast import If
import sys
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans, sum = nums[0], 0

        for n in nums:
            if sum < 0:
                sum = n
            else:
                sum += n
            if ans < sum:
                ans = sum

        return ans
