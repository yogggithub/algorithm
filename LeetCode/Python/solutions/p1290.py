from Python.auxiliary.ListNode import ListNode


class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 54 ms @ (beats) 6.53%
        # Memory Usage: 14.3 MB @ (beats) 6.91%
        #
        # ans = 0
        # while head:
        #     ans = ans * 2 + head.val
        #     head = head.next
        # return ans

        #
        # (learn from Internet)
        # Solution v2: Bit
        #
        ans = head.val
        while head := head.next:
            ans = ans << 1 | head.val
        return ans
