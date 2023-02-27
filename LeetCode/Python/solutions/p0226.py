import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        #
        # Solution v1: Recursive
        #
        # Runtime: 43 ms @ (beats) 15.93%
        # Memory Usage: 13.7 MB @ (beats) 94.98%
        #
        # ans = None
        #
        # if not root:
        #     return ans
        #
        # ans = TreeNode()
        # ans.val = root.val
        #
        # ans.left = self.invertTree(root.right)
        # ans.right = self.invertTree(root.left)
        #
        # return ans

        #
        # Solution v1.1: Recursive in place
        #
        # Runtime: 34 ms @ (beats) 59.87%
        # Memory Usage: 13.9 MB @ (beats) 7.55%
        #

        # if not root:
        #     return None
        #
        # temp = root.left
        #
        # root.left = root.right
        # root.right = temp
        #
        # if root.left:
        #     self.invertTree(root.left)
        #
        # if root.right:
        #     self.invertTree(root.right)
        #
        # return root

        #
        # Solution v2: Iterative
        #
        # Runtime: 35 ms @ (beats) 52.26%
        # Memory Usage: 14 MB @ (beats) 7.55%
        #

        if not root:
            return None

        q = collections.deque()
        q.append(root)

        while q:
            node = q.popleft()

            if not node:
                continue

            temp = node.left

            node.left = node.right
            node.right = temp

            q.append(node.left)
            q.append(node.right)

        return root