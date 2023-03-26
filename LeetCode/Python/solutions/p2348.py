from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:

        #
        # Solution v1: Brute Force
        #
        # Runtime: 1090 ms @ (beats) 76.32%
        # Memory Usage: 24.5 MB @ (beats) 78.9%
        #
        # ans = 0
        #
        # sub = 0
        # for i in range(len(nums)):
        #     if nums[i]:
        #         ans += sum(range(1, sub + 1))
        #         sub = 0
        #     else:
        #         sub += 1
        #
        # ans += sum(range(1, sub + 1))
        #
        # return ans

        #
        # Solution v1.5: Brute Force
        # Simplify Algorithm
        #
        # Runtime: 1069 ms @ (beats) 85.87%
        # Memory Usage: 24.7 MB @ (beats) 30.39%
        #
        ans = 0
        sub = 0
        for n in nums:
            # increment the counter if nums[i]= 0
            if n:
                sub = 0
            else:
                sub += 1
            # accumulate counter to answer for each element
            ans += sub

        return ans


if __name__ == "__main__":
    solution = Solution()

    nums = [1, 3, 0, 0, 2, 0, 0, 4]
    print(f"return: {solution.zeroFilledSubarray(nums)}")  # 6

    nums = [0, 0, 0, 2, 0, 0]
    print(f"return: {solution.zeroFilledSubarray(nums)}")  # 9

    nums = [2, 10, 2019]
    print(f"return: {solution.zeroFilledSubarray(nums)}")  # 0
