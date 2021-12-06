from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 24 ms @ (beats) 98.60%
        # Memory Usage: 14.2 MB @ (beats) 48.87%
        #
        if len(nums) == 0:
            return 0
        elif len(nums) < 2:
            return 1 if nums[0] != val else 0

        left = 0
        right = len(nums) - 1
        while left <= right:
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
            else:
                left += 1

        return left
