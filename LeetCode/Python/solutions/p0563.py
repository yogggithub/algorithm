from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 965 ms @ (beats) 5.09%
        # Memory Usage: 16.5 MB @ (beats) 7.15%
        #
        # if not root:
        #     return 0
        # elif not root.left and not root.right:
        #     return 0
        # else:
        #     tilt = TreeNode()
        #     tilt = self.tilthelper(root, tilt)
        #
        # return self.sumhelper(tilt)

        #
        # (learn from Internet)
        # Solution v2:
        #
        res = 0

        def dfs(node):
            nonlocal res
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            res += abs(left - right)

            return left + right + node.val

        dfs(root)
        return res

    def tilthelper(self, root: TreeNode, tilt: TreeNode) -> TreeNode:
        tilt.val = abs(self.sumhelper(root.left) - self.sumhelper(root.right))

        if root.left:
            tilt.left = TreeNode()
            tilt.left = self.tilthelper(root.left, tilt.left)
        if root.right:
            tilt.right = TreeNode()
            tilt.right = self.tilthelper(root.right, tilt.right)
        return tilt

    def sumhelper(self, root) -> int:
        if not root:
            return 0
        elif not root.left and not root.right:
            return root.val
        else:
            return root.val + self.sumhelper(root.left) + self.sumhelper(root.right)
