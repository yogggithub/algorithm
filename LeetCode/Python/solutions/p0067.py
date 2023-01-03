class Solution:
    def addBinary(self, a: str, b: str) -> str:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 28 ms @ (beats) 93.11%
        # Memory Usage: 14.1 MB @ (beats) 81.06%
        #
        a_len = len(a) - 1
        b_len = len(b) - 1
        carry = 0
        ans = ""
        while a_len >= 0 or b_len >= 0:
            a_cha = "0"
            b_cha = "0"
            if a_len >= 0:
                a_cha = a[a_len]
            if b_len >= 0:
                b_cha = b[b_len]
            sum_ = int(a_cha) + int(b_cha) + carry
            ans += str(sum_ % 2)
            carry = sum_ // 2
            a_len -= 1
            b_len -= 1

        if carry > 0:
            ans += str(carry)

        return ans[::-1]
