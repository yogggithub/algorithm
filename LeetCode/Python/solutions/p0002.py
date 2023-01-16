from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        #
        # Solution v1: iterative
        #
        # Runtime: 71 ms @ (beats) 77.38%
        # Memory Usage: 14 MB @ (beats) 9.40%
        #

        # ans = ListNode()
        # surplus = 0
        #
        # temp = ans
        # while l1 or l2:
        #     i = 0
        #     j = 0
        #     if l1:
        #         i = l1.val
        #         l1 = l1.next
        #     if l2:
        #         j = l2.val
        #         l2 = l2.next
        #
        #     temp.val = int((i + j + surplus) % 10)
        #     surplus = int((i + j + surplus) / 10)
        #
        #     if l1 or l2:
        #         temp.next = ListNode()
        #         temp = temp.next
        #
        # if surplus > 0:
        #     temp.next = ListNode(surplus)
        #
        # return ans

        #
        # Solution v2: recursive
        #
        # Runtime: 71 ms @ (beats) 77.38%
        # Memory Usage: 14 MB @ (beats) 9.40%
        #
        ans = ListNode()

        def func(x, y, nodes, surplus):
            if not x and not y:
                return
            temp = ListNode()
            nodes.next = temp

            i = 0
            j = 0
            if x:
                i = x.val
            if y:
                j = y.val

            temp.val = int((i + j + surplus) % 10)
            surplus = int((i + j + surplus) / 10)

            func(x.next, y.next, nodes.next, surplus)

        t = ans
        func(l1, l2, t, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()

    l1 = [2, 4, 3]
    l2 = [5, 6, 4]
    print(f"return: {solution.addTwoNumbers(l1, l2)}")  # [7, 0 ,8]

    print(f"return: {solution.addTwoNumbers(l1, l2)}")
