import math
from typing import List


class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        #
        # Solution v2: Kadane's Algorithm
        #
        # idea:
        # when array is circular, if the maxi subarray took out
        # the left part is minimum part

        totalSum = 0
        currMaxSum = 0
        currMinSum = 0
        maxSum = -math.inf
        minSum = math.inf

        for n in nums:
            totalSum += n
            # dp: dp[i] = dp[i-1] + nums[1]
            currMaxSum = max(currMaxSum + n, n)
            currMinSum = min(currMinSum + n, n)
            maxSum = max(maxSum, currMaxSum)
            minSum = min(minSum, currMinSum)

        # corner case: full negative array
        # return the single maximum number
        return maxSum if maxSum < 0 else max(maxSum, totalSum - minSum)


if __name__ == "__main__":
    solution = Solution()

    nums = [1, -2, 3, -2]
    print(f"return: {solution.maxSubarraySumCircular(nums)}")  # 3 -> [3]

    nums = [5, -3, 5]
    print(f"return: {solution.maxSubarraySumCircular(nums)}")  # 10 -> [5, 5]

    nums = [-3, -2, -3]
    print(f"return: {solution.maxSubarraySumCircular(nums)}")  # -2 -> [-2]

    nums = [3, -1, 2, -1]
    print(f"return: {solution.maxSubarraySumCircular(nums)}")  # 4 -> [2, -1 ,3]
