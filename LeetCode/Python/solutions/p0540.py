from typing import List


class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if mid % 2 != 0:
                mid -= 1

            if nums[mid] != nums[mid + 1]:
                right = mid
            else:
                left = mid + 2

        return nums[left]


if __name__ == "__main__":
    solution = Solution()

    nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
    print(f"return: {solution.singleNonDuplicate(nums)}")  # 2

    nums = [3, 3, 7, 7, 10, 11, 11]
    print(f"return: {solution.singleNonDuplicate(nums)}")  # 10
