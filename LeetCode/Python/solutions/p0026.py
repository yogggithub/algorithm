from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)

        #
        # Solution v1: Brute Force
        #
        # Runtime: 107 ms @ (beats) 40.34%
        # Memory Usage: 15.6 MB @ (beats) 80.45%
        #
        k = 0

        for i in range(len(nums)):
            if i == 0:
                nums[k] = nums[i]
                k += 1
            else:
                if nums[i - 1] < nums[i]:
                    nums[k] = nums[i]
                    k += 1

        return k


#
# (learn from Internet)
# Solution v2:
#
def removeDuplicates(self, nums: List[int]) -> int:
    l = len(nums) - 1
    lastStart = 0
    lastPlace = 1
    i = 0
    while i <= l:
        if nums[i] != nums[lastStart]:
            nums[lastPlace] = nums[i]
            lastStart = i
            lastPlace += 1
        i += 1
    return lastPlace
