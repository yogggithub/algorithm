import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #
        # Solution v1: BFS
        #
        # Runtime: 30 ms @ (beats) 81.13%
        # Memory Usage: 13.9 MB @ (beats) 54.57%
        #
        # ans = []
        #
        # q = collections.deque()
        # q.append(("", root))
        #
        # while q:
        #     num, curr = q.popleft()
        #
        #     if not curr:
        #         continue
        #
        #     num = f"{num}{curr.val}"
        #
        #     if curr.left or curr.right:
        #         q.append((num, curr.left))
        #         q.append((num, curr.right))
        #     else:
        #         ans.append(int(num))
        #
        # return sum(ans)

        #
        # Solution v1: BFS
        # int instead of str
        #
        # Runtime: 37 ms @ (beats) 33.24%
        # Memory Usage: 13.9 MB @ (beats) 54.57%
        #
        # ans = []
        #
        # q = collections.deque()
        # q.append((0, root))
        #
        # while q:
        #     num, curr = q.popleft()
        #
        #     if not curr:
        #         continue
        #
        #     num = num * 10 + curr.val
        #
        #     if curr.left or curr.right:
        #         q.append((num, curr.left))
        #         q.append((num, curr.right))
        #     else:
        #         ans.append(num)
        #
        # return sum(ans)

        #
        # Solution v2: BFS Recursive
        #
        # Runtime: 32 ms @ (beats) 70.48%
        # Memory Usage: 13.9 MB @ (beats) 54.57%
        #

        def dfs(head, val):
            if not head:
                return 0

            new_v = val * 10 + head.val

            if not head.left and not head.right:
                return new_v

            return dfs(head.left, new_v) + dfs(head.right, new_v)

        return dfs(root, 0)
