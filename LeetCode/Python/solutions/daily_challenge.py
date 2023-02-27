from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # j = 0
        # while True:
        #     i = len(nums) // 2
        #
        #     if len(nums) == 1:
        #         return j if target <= nums[0] else j + 1
        #
        #     if target == nums[i]:
        #         return i + j
        #     elif target < nums[i]:
        #         nums = nums[:i]
        #     else:
        #         nums = nums[i:]
        #         j += i

        start = 0
        end = len(nums) - 1

        while start < end:
            mid = (end + start) // 2

            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                end = mid - 1
            else:
                start = mid + 1

        if target <= nums[start]:
            return start
        else:
            return start + 1


if __name__ == "__main__":
    solution = Solution()

    nums = [1, 3, 5, 6]
    target = 5
    print(f"return: {solution.searchInsert(nums, target)}")  # 2

    target = 2
    print(f"return: {solution.searchInsert(nums, target)}")  # 1

    target = 7
    print(f"return: {solution.searchInsert(nums, target)}")  # 4

    nums = [1, 3]
    target = 3
    print(f"return: {solution.searchInsert(nums, target)}")  # 1
