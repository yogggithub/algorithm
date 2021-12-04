from typing import Optional

from leetcode.python.auxiliary.ListNode import ListNode


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ans = odd = ListNode()
        even = ListNode()
        dummy = even

        while head:
            odd.next = head
            odd = odd.next
            even.next = head.next
            even = even.next
            head = head.next.next if even else None

        even.next = None
        odd.next = dummy
        return ans.next
