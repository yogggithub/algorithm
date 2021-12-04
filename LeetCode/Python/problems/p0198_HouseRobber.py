from typing import List


class Solution:
    def rob1(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        ans = [*nums]
        ans[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            ans[i] = max(ans[i - 1], ans[i - 2] + nums[i])

        return ans[-1]

    def rob2(self, nums: List[int]) -> int:
        prev2, prev, cur = 0, 0, 0
        for i in nums:
            cur = max(prev, i + prev2)
            prev2 = prev
            prev = cur
        return cur
