import collections
from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:

        #
        # Solution v1: Brute Force
        #
        # Runtime: 54 ms @ (beats) 57.68%
        # Memory Usage: 17.6 MB @ (beats) 29.94%
        #
        # repo = collections.defaultdict(list)
        #
        # while head:
        #     val = head.val
        #
        #     for node in repo[val]:
        #         if head.next == node.next:
        #             return node
        #     repo[val].append(head)
        #
        #     head = head.next
        #
        # return None

        #
        # Solution v1.1: Brute Force
        # it is possible to directly compare two nodes
        #
        # Runtime: 55 ms @ (beats) 52.57%
        # Memory Usage: 17.7 MB @ (beats) 29.94%
        #
        # repo = collections.defaultdict(list)
        #
        # while head:
        #     val = head.val
        #
        #     if head in repo[val]:
        #         return head
        #     repo[val].append(head)
        #
        #     head = head.next
        #
        # return None

        #
        # Solution v1.2: Brute Force
        # use node as key of dict
        #
        # Runtime: 59 ms @ (beats) 31.75%
        # Memory Usage: 17.8 MB @ (beats) 27.9%
        #
        # repo = {}
        #
        # while head:
        #     if head in repo:
        #         return head
        #     repo[head] += 1
        #
        #     head = head.next
        #
        # return None

        #
        # Solution v1.3: Brute Force
        # use a set() which does not allow duplicate element
        #
        # Runtime: 51 ms @ (beats) 74.25%
        # Memory Usage: 18 MB @ (beats) 8.78%
        #
        # repo = set()
        #
        # while head:
        #     if head in repo:
        #         return head
        #     repo.add(head)
        #
        #     head = head.next
        #
        # return None

        #
        # Solution v2: Two pointers
        #
        # Runtime: 59 ms @ (beats) 31.75%
        # Memory Usage: 17.4 MB @ (beats) 31.92%
        #
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                break

        if not fast or not fast.next:
            return None

        slow = head

        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow
