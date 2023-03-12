from typing import Optional

from Python.auxiliary.ListNode import ListNode
from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        #
        # Solution v1: Recursive
        #
        # Runtime: 141 ms @ (beats) 15.86%
        # Memory Usage: 20.3 MB @ (beats) 26.41%
        #
        # def helper(vals: list) -> Optional[TreeNode]:
        #     if not vals:
        #         return None
        #
        #     tree = TreeNode()
        #     mid = len(vals) // 2
        #     tree.val = vals[mid]
        #     tree.left = helper(vals[:mid])
        #     tree.right = helper(vals[mid + 1:])
        #     return tree
        #
        # nodes = []
        # while head:
        #     nodes.append(head.val)
        #     head = head.next
        #
        # return helper(nodes)

        #
        # Solution v2: Two pointer to find middle node
        #
        # Runtime: 121 ms @ (beats) 82.47%
        # Memory Usage: 17.7 MB @ (beats) 76.91%
        #

        if not head:
            return None
        elif not head.next:
            return TreeNode(head.val)

        slow = head
        fast = head.next.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        tree = TreeNode(slow.next.val)

        tree.right = self.sortedListToBST(slow.next.next)

        # cut the ListNode
        slow.next = None

        tree.left = self.sortedListToBST(head)

        return tree

