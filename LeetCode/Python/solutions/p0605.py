from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 551 ms @ (beats) 5.3%
        # Memory Usage: 116.2 MB @ (beats) 20.94%
        #
        # if n == 0:
        #     return True
        #
        # if n == len(flowerbed):
        #     return len(flowerbed) == 1 and flowerbed[0] == 0
        #
        # for i in range(len(flowerbed) - 2):
        #     if flowerbed[i] == 0:
        #         if i == 0 and flowerbed[i + 1] == 0:
        #             flowerbed[0] = 1
        #             return self.canPlaceFlowers(flowerbed, n - 1)
        #
        #         if flowerbed[i + 1] + flowerbed[i + 2] == 0:
        #             flowerbed[i + 1] = 1
        #             return self.canPlaceFlowers(flowerbed[i + 1:], n - 1)
        #
        # if flowerbed[-2] + flowerbed[-1] == 0:
        #     return n == 1
        #
        # return False

        #
        # Solution v2: Brute Force
        #
        # Runtime: 159 ms @ (beats) 89.8%
        # Memory Usage: 14.3 MB @ (beats) 65.78%
        #
        # if not n:
        #     return True
        #
        # # start from 1
        # # coz it is True if first two slots are 0s
        # count = 1
        #
        # # add a 0 at the end
        # # coz it is True if last two slots are 0s
        # flowerbed.append(0)
        #
        # for p in flowerbed:
        #     if p == 0:
        #         count += 1
        #         if count == 3:
        #             n -= 1
        #             if n == 0:
        #                 return True
        #             # reset count to 1
        #             # coz the fist available slot is 2nd afterward
        #             count = 1
        #     else:
        #         # when current slot is 1
        #         # has to consider next three slots
        #         count = 0
        #
        # return False

        #
        # Solution v2: Brute Force
        # Simplify
        #
        # Runtime: 186 ms @ (beats) 19.61%
        # Memory Usage: 14.3 MB @ (beats) 65.78%
        #
        if not n:
            return True

        count = 0
        flowerbed.append(0)

        for i in range(len(flowerbed) - 1):
            curr = flowerbed[i]

            if curr == 0:
                pre = flowerbed[i - 1] if i > 0 else 0
                nxt = flowerbed[i + 1]

                if pre + nxt == 0:
                    flowerbed[i] = 1
                    count += 1

        return count >= n
