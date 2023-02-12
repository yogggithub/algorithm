from typing import List


class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 60 ms @ (beats) 84.21%
        # Memory Usage: 14.2 MB @ (beats) 33.52%
        #

        ans = []
        for i in range(n):
            ans.append(nums[i])
            ans.append(nums[i + n])

        return ans

        #
        # Solution v2:
        #
        # Runtime: ms @ (beats) %
        # Memory Usage: MB @ (beats) %
        #


if __name__ == "__main__":
    solution = Solution()

    nums = [2, 5, 1, 3, 4, 7]
    n = 3
    print(f"return: {solution.shuffle(nums, n)}")  # [2,3,5,4,1,7]

    nums = [1, 2, 3, 4, 4, 3, 2, 1]
    n = 4
    print(f"return: {solution.shuffle(nums, n)}")  # [1,4,2,3,3,2,4,1]

    nums = [1, 1, 2, 2]
    n = 2
    print(f"return: {solution.shuffle(nums, n)}")  # [1,2,1,2]
