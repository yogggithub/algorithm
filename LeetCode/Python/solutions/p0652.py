import collections
from typing import Optional, List

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        ans = []
        counter = collections.Counter()

        def helper(tree: Optional[TreeNode]) -> str:
            if not tree:
                return ""

            # has to add some split char to avoid duplicate node val issue
            key = f"{str(tree.val)}|{helper(tree.left)}|{helper(tree.right)}"

            nonlocal counter
            counter[key] += 1

            # only add when reach 2
            if counter[key] == 2:
                ans.append(tree)

            return key

        helper(root)

        return ans
