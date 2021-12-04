from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currMax, currMin = 1, 1
        res = nums[0]

        for n in nums:
            temp = (n, n * currMax, n * currMin)
            currMax, currMin = max(temp), min(temp)

            res = max(res, currMax)

        return res