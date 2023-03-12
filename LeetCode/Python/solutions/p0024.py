from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 37 ms @ (beats) 34.90%
        # Memory Usage: 13.9 MB @ (beats) 12.36%
        #
        # ans = ListNode()
        # ans.next = head
        # head = ans
        #
        # while head and head.next:
        #     child = head.next
        #     grand_child = head.next.next
        #
        #     if grand_child:
        #         child.next = grand_child.next
        #         grand_child.next = child
        #         head.next = grand_child
        #         head = head.next.next
        #     else:
        #         break
        #
        # return ans.next

        #
        # Solution v1.1: Optimising logic and streamlining code
        #
        # Runtime: 37 ms @ (beats) 34.90%
        # Memory Usage: 13.9 MB @ (beats) 12.36%
        #
        # ans = ListNode()
        # ans.next = head
        # head = ans
        #
        # while head.next and head.next.next:
        #     second = head.next
        #     third = head.next.next
        #
        #     second.next = third.next
        #     third.next = second
        #     head.next = third
        #     head = second
        #
        # return ans.next

        #
        # Solution v2: Recusive
        #
        # Runtime:  ms @ (beats) %
        # Memory Usage:  MB @ (beats) %
        #
        if not head or not head.next:
            return head

        ans = ListNode(0, head)
        head = ans

        second = head.next
        third = head.next.next
        third.next = self.swapPairs(third.next)
        second.next = third.next
        third.next = second
        head.next = third

        return ans.next



