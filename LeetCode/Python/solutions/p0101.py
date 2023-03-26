import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 41 ms @ (beats) 29.46%
        # Memory Usage: 14.1 MB @ (beats) 14.51%
        #
        # def helper(tree, reverse=False):
        #     vals = []
        #     q = collections.deque()
        #     q.append(tree)
        #
        #     while q:
        #         curr = q.popleft()
        #
        #         if not curr:
        #             vals.append(None)
        #             continue
        #
        #         vals.append(curr.val)
        #
        #         if reverse:
        #             q.append(curr.left)
        #             q.append(curr.right)
        #         else:
        #             q.append(curr.right)
        #             q.append(curr.left)
        #
        #     return vals
        #
        # left = helper(root.left)
        # right = helper(root.right, True)
        #
        # return left == right

        #
        # Solution v2: Recursive
        #
        # Runtime: 40 ms @ (beats) 35.55%
        # Memory Usage: 13.9 MB @ (beats) 90.34%
        #

        # def check_mirror(left, right):
        #     if not left and not right:
        #         return True
        #     elif not left or not right:
        #         return False
        #     else:
        #         if left.val != right.val:
        #             return False
        #
        #         return check_mirror(left.left, right.right) and \
        #             check_mirror(left.right, right.left)
        #
        # return check_mirror(root.left, root.right)

        #
        # Solution v2.1: Recursive
        # Performance enhance
        #
        # Runtime: 33 ms @ (beats) 79.23%
        # Memory Usage: 14 MB @ (beats) 14.51%
        #
        def check_mirror(left, right):
            if not left and not right:
                return True

            if not left or not right:
                return False

            if left.val != right.val:
                return False

            return check_mirror(left.left, right.right) and \
                check_mirror(left.right, right.left)

        return check_mirror(root.left, root.right)