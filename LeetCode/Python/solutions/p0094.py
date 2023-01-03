from typing import Optional, List

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []

        #
        # Solution v1: Recursive
        #
        # Runtime: 28 ms @ (beats) 86.32%
        # Memory Usage: 14 MB @ (beats) 98.80%
        #
        # def helper(root: Optional[TreeNode], ans: List[int]):
        #     if root:
        #         helper(root.left, ans)
        #         ans.append(root.val)
        #         helper(root.right, ans)
        #
        # helper(root, ans)
        # return ans

        #
        # Solution v2: Iterative
        #
        # Runtime: 36 ms @ (beats) 25.28%
        # Memory Usage: 14.3 MB @ (beats) 13.91%
        #
        stack = []

        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                node = stack.pop()
                ans.append(node.val)
                root = node.right

        return ans