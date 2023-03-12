from typing import List


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 54 ms @ (beats) 65.76%
        # Memory Usage: 14 MB @ (beats) 80.43%
        #
        # count = 0
        # n = 1
        # i = 0
        # while i < len(arr):
        #     if n != arr[i]:
        #         count += 1
        #         if count >= k:
        #             return n
        #         n += 1
        #         continue
        #     i += 1
        #     n += 1
        #
        # if count < k:
        #     return arr[-1] + k - count

        #
        # Solution v2 Binary
        #
        # Runtime: ms @ (beats) %
        # Memory Usage: MB @ (beats) %
        #
        left = 0
        length = len(arr)
        right = length - 1

        while left <= right:
            mid = left + (right - left) // 2
            missing = arr[mid] - (mid + 1)

            if missing < k:
                left = mid + 1
            else:
                right = mid - 1
                length = mid

        return length + k


if __name__ == "__main__":
    solution = Solution()

    arr = [2, 3, 4, 7, 11]
    k = 5
    print(f"return: {solution.findKthPositive(arr, k)}")  # 9

    arr = [1, 2, 3, 4]
    k = 2
    print(f"return: {solution.findKthPositive(arr, k)}")  # 6

    arr = [2]
    k = 1
    print(f"return: {solution.findKthPositive(arr, k)}")  # 1
