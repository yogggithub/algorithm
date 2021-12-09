from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        #
        # Solution v1: Binary Search
        #
        # Runtime: 52 ms @ (beats) 54.34%
        # Memory Usage: 15 MB @ (beats) 56.27%
        #
        left = 0
        right = len(nums) - 1

        if target < nums[left]:
            return 0
        elif target > nums[right]:
            return right + 1
        else:
            while left <= right:
                mid = left + (right - left) // 2
                if target == nums[mid]:
                    return mid
                elif target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid
            return left