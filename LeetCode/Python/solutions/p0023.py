import collections
from typing import List, Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #
        # Solution v1: Back Track
        #
        # Runtime: 85 ms @ (beats) 99.9%
        # Memory Usage: 18.4 MB @ (beats) 17.41%
        #
        vals = []
        for nodes in lists:
            x = nodes
            while x:
                vals += [x.val]
                x = x.next

        vals = sorted(vals, reverse=True)

        ans = None
        for val in vals:
            ans = ListNode(val, ans)
        return ans
