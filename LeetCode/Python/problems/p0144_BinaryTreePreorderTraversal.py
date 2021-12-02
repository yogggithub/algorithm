from typing import Optional, List

from leetcode.python.auxiliary.TreeNode import TreeNode


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        self.dfs(root, ans)
        return ans

    def dfs(self, root, ans):
        if root:
            ans.append(root.val)
            self.dfs(root.left, ans)
            self.dfs(root.right, ans)
