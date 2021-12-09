from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 43 ms @ (beats) 19.40%
        # Memory Usage: 14.2 MB @ (beats) 48.39%
        #
        # carry = 0
        # i = len(digits) - 1
        # num = digits[i] + carry + 1
        # while i >= 0:
        #     if num < 10:
        #         digits[i] = num
        #         carry = 0
        #         break
        #     else:
        #         digits[i] = num % 10
        #         carry = num // 10
        #         num = digits[i] + carry
        #         i -= 1
        #
        # if carry > 0:
        #     digits.insert(0, carry)
        #
        # return digits

        #
        # (learn from Internet)
        # Solution v2:
        #
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] + 1 < 10:
                digits[i] = digits[i] + 1
                return digits
            else:
                digits[i] = digits[i] + 1 - 10
                i = i + 1
        return [1] + digits
