from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 247 ms @ (beats) 48.31%
        # Memory Usage: 15.4 MB @ (beats) 58.56%
        #
        # left = 0
        # right = len(nums) - 1
        #
        # while left <= right:
        #     mid = (left + right) // 2
        #     if nums[mid] == target:
        #         return mid
        #     elif nums[mid] < target:
        #         left = mid + 1
        #     else:
        #         right = mid - 1
        #
        # return -1

        #
        # Solution v1.1: Brute Force
        #
        # Runtime: 229 ms @ (beats) 98.23%
        # Memory Usage: 15.4 MB @ (beats) 58.56%
        #

        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid

        return -1


if __name__ == "__main__":
    solution = Solution()

    # nums = [-1, 0, 3, 5, 9, 12]
    # target = 9
    # print(f"return: {solution.search(nums, target)}")   # 4

    nums = [-1, 0, 3, 5, 9, 12]
    target = 2
    print(f"return: {solution.search(nums, target)}")   # -1


