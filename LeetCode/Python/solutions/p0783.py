import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        #
        # Solution v1: Sort
        #
        # Runtime: 36 ms @ (beats) 50.70%
        # Memory Usage: 13.8 MB @ (beats) 74.83%
        #
        arr = []

        q = collections.deque()
        q.append(root)

        while q:
            node = q.popleft()

            if not node:
                continue

            arr.append(node.val)

            q.append(node.left)
            q.append(node.right)

        arr.sort()

        ans = float('inf')

        for i in range(1, len(arr)):
            ans = min(ans, arr[i] - arr[i - 1])

        return ans