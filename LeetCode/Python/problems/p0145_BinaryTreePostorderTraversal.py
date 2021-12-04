from typing import Optional, List

from leetcode.python.auxiliary.TreeNode import TreeNode


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        ans, stack = [], [root]

        while stack:
            node = stack.pop()
            if node:
                ans.append(node.val)
                stack.append(node.left)
                stack.append(node.right)

        return ans[::-1]
