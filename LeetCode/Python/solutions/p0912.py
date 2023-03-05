from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        #
        # Solution v1: Merge Sort
        #
        # Runtime: 2855 ms @ (beats) 16%
        # Memory Usage: 23.5 MB @ (beats) 23.30%
        #
        if len(nums) < 2:
            return nums

        def merge_sort(left, right):
            result = []
            while left and right:
                if left[0] <= right[0]:
                    result.append(left.pop(0))
                else:
                    result.append(right.pop(0))
            while left:
                result.append(left.pop(0))
            while right:
                result.append(right.pop(0))
            return result

        middle = len(nums) // 2
        left, right = nums[0:middle], nums[middle:]
        return merge_sort(self.sortArray(left), self.sortArray(right))

        #
        # Solution v2: Quick Sort
        #
        # Time Limit Exceeded
        #
        # if len(nums) < 2:
        #     return nums
        #
        # pivot = nums[len(nums) // 2]
        # left = [x for x in nums if x < pivot]
        # mid = [y for y in nums if y == pivot]
        # right = [z for z in nums if z > pivot]
        #
        # return self.sortArray(left) + mid + self.sortArray(right)


if __name__ == "__main__":
    solution = Solution()

    nums = [5, 2, 3, 1]
    print(f"return: {solution.sortArray(nums)}")  # [1,2,3,5]

    nums = [5, 1, 1, 2, 0, 0]
    print(f"return: {solution.sortArray(nums)}")  # [0,0,1,1,2,5]
