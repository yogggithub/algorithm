class Solution:
    def mySqrt(self, x: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 4908 ms @ (beats) 5.01%
        # Memory Usage: 14.1 MB @ (beats) 90.00%
        #
        # if x < 2:
        #     return x
        # elif x < 4:
        #     return 1
        # elif x < 9:
        #     return 2
        #
        # for i in range(2, x // 2):
        #     if i <= x // i and (i + 1) >= x // (i + 1):
        #         return i
        #
        # return -1

        #
        # Solution v2: Binary Search
        #
        # Runtime: 28 ms @ (beats) 96.90%
        # Memory Usage: 14.2 MB @ (beats) 70.60%
        #
        if x < 2:
            return x
        elif x < 4:
            return 1
        elif x < 9:
            return 2

        left, right = 2, x // 2

        while left < right:
            mid = left + (right - left) // 2
            if mid <= x // mid and (mid + 1) > x // (mid + 1):
                return mid
            elif mid > x // mid:
                right = mid
            else:
                left = mid

        return left
