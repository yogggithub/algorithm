from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def helper(curr, is_used, ans):
            # nonlocal nums
            if len(nums) == len(curr):
                ans.append(curr[:])
                return

            for i, n in enumerate(nums):
                if is_used[i]:
                    continue
                curr.append(n)
                is_used[i] = True
                helper(curr, is_used, ans)
                curr.pop()
                is_used[i] = False

        ans = []
        helper([], [False] * len(nums), ans)
        return ans


