from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:

        steps = 0
        next_pos = 0
        reachable = 0

        for i in range(len(nums) - 1):
            next_pos = max(next_pos, i + nums[i])

            if i == reachable:
                steps += 1
                reachable = next_pos

        return steps


if __name__ == "__main__":
    solution = Solution()
    #
    # nums = [2, 3, 1, 1, 4]
    # print(f"return: {solution.jump(nums)}")  # 2

    nums = [2, 2, 0, 1, 4]
    print(f"return: {solution.jump(nums)}")  # 2

    # nums = [5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0,
    #         3, 8, 5]
    # print(f"return: {solution.jump(nums)}")  # 5
