import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        #
        # Solution v1: Binary Search
        #
        # Runtime: 458 ms @ (beats) 79.97%
        # Memory Usage: 15.3 MB @ (beats) 97.76%
        #

        # # lowest speed is 1 banana per hour
        # l = 1
        # # the highest is the max pile amount
        # # coz Koko would not eat another pile
        # r = max(piles)
        #
        # while l < r:
        #     mid = (l + r) // 2
        #     hours = 0
        #     for p in piles:
        #         hours += p // mid
        #         if p % mid:
        #             hours += 1
        #
        #     if hours > h:
        #         l = mid + 1
        #     else:
        #         r = mid
        #
        # return l

        #
        # Solution v1.1: Binary Search
        # Narrow the lower and upper boundary
        #
        # Runtime: 154 ms @ (beats) 99.99%
        # Memory Usage: 15.5 MB @ (beats) 16.17%
        #

        total = sum(piles)
        # coz Koko would not eat another pile
        # the lowest should be the time that allows it eats all bananas
        # at least, it will cost 1 hour
        l = max(total // h, 1)
        # the highest is that eat one pile at a time
        r = math.ceil(total / (h - len(piles) + 1))

        while l < r:
            mid = (l + r) // 2
            hours = sum(math.ceil(p / mid) for p in piles)

            if hours > h:
                l = mid + 1
            else:
                r = mid

        return l


if __name__ == "__main__":
    solution = Solution()

    piles = [3, 6, 7, 11]
    h = 8
    print(f"return: {solution.minEatingSpeed(piles, h)}")  # 4

    piles = [30, 11, 23, 4, 20]
    h = 5
    print(f"return: {solution.minEatingSpeed(piles, h)}")  # 30

    piles = [30, 11, 23, 4, 20]
    h = 6
    print(f"return: {solution.minEatingSpeed(piles, h)}")  # 23

    piles = [312884470]
    h = 968709470
    print(f"return: {solution.minEatingSpeed(piles, h)}")  # 23
