from typing import List


class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        #
        # Solution v1: Map element to its reminder
        #
        ans = 0
        curr_sum = 0
        reminder = 0
        mp = {}
        mp[reminder] = 1

        for n in nums:
            curr_sum += n
            r = curr_sum % k

            # for negative element, make reminder positive
            if r < 0:
                r += k

            # update the reminder map
            if r in mp:
                # increment mp[r] because all subarrays can add this element
                # that means the total amount will double
                ans += mp[r]
                mp[r] += 1
            else:
                # insert to map if there is no
                mp[r] = 1

        return ans


if __name__ == "__main__":
    solution = Solution()

    nums = [4, 5, 0, -2, -3, 1]
    k = 5
    print(f"return: {solution.subarraysDivByK(nums, k)}")  # 7

    nums = [5, 1, 0, 5]
    k = 5
    print(f"return: {solution.subarraysDivByK(nums, k)}")  # 3
