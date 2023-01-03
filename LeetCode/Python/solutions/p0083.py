from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #
        # Solution v1.1: Brute Force
        #
        # Runtime: 40 ms @ (beats) 82.40%
        # Memory Usage: 14.1 MB @ (beats) 83.20%
        #
        # if not head or not head.next:
        #     return head
        #
        # ans = ListNode()
        # ans.next = temp = ListNode(head.val)
        # while head:
        #     if head.val > temp.val:
        #         temp.next = ListNode(head.val)
        #         temp = temp.next
        #     head = head.next
        #
        # return ans.next

        #
        # Solution v1.2: Optimize
        #
        # Runtime: 36 ms @ (beats) 94.65%
        # Memory Usage: 14.3 MB @ (beats) 25.29%
        #
        if not head or not head.next:
            return head

        ans = ListNode()
        ans.next = temp = head
        while head:
            if head.val == temp.val:
                temp.next = head.next
            head = head.next

        return ans.next