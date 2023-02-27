import collections
from typing import Optional, List

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #
        # Solution v1: Iterative
        #
        # Runtime: 23 ms @ (beats) 99.1%
        # Memory Usage: 14.2 MB @ (beats) 48.21%
        #
        # ans = []
        # if root:
        #     q = collections.deque()
        #     q.append((root, 0))
        #
        #     while q:
        #         node, lvl = q.popleft()
        #
        #         if not node:
        #             continue
        #
        #         val = node.val
        #         if lvl >= len(ans):
        #             ans.append([val])
        #         else:
        #             if lvl % 2 == 0:
        #                 ans[lvl].append(val)
        #             else:
        #                 ans[lvl].insert(0, val)
        #
        #         q.append((node.left, lvl + 1))
        #         q.append((node.right, lvl + 1))
        #
        # return ans

        #
        # Solution v1: Recursive
        #
        # Runtime: 36 ms @ (beats) 58.29%
        # Memory Usage: 14.1 MB @ (beats) 94.5%
        #

        ans = []

        def helper(node, lvl):
            nonlocal ans

            if node:
                if lvl >= len(ans):
                    ans.append([])

                val = node.val

                if lvl % 2 == 0 or not ans[lvl]:
                    ans[lvl].append(val)
                else:
                    ans[lvl].insert(0, val)

                helper(node.left, lvl + 1)
                helper(node.right, lvl + 1)

        if root:
            helper(root, 0)

        return ans
