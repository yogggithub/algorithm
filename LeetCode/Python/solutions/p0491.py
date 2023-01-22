from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 239 ms @ (beats) 67.50%
        # Memory Usage: 24.8 MB @ (beats) 15.47%
        #
        # idea:
        # 1. create a subarray for each element in nums
        #       assume them may be protential answer
        # 2. compare current element to observed subarray
        #       if it is smaller one than add to all applicable
        # 3. eliminate duplicate and return

        ans = [[nums[0]]]
        for n in nums[1:]:
            ans += [c + [n] for c in ans if n >= c[-1]]
            ans += [[n]]

        # cast to Tuple to avoid unhashable error
        ans = [tuple(i) for i in ans if len(i) > 1]

        return list(set(ans))


if __name__ == "__main__":
    solution = Solution()

    nums = [4, 6, 7, 7]
    print(f"return: {solution.findSubsequences(nums)}")
    # [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

    nums = [4, 4, 3, 2, 1]
    print(f"return: {solution.findSubsequences(nums)}")  # [[4,4]]
