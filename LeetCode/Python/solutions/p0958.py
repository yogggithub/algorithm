import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        #
        # Solution v1: BFS
        #
        # Runtime: 45 ms @ (beats) 13.99%
        # Memory Usage: 13.8 MB @ (beats) 96.89%
        #

        # q = [(root, 0)]
        # missed = collections.defaultdict(bool)
        #
        # while q:
        #     node, lvl = q.pop(0)
        #
        #     if not node:
        #         continue
        #
        #     if not node.left and node.right:
        #         return False
        #
        #     if not node.left or not node.right:
        #         missed[lvl] = True
        #
        #     if node.left or node.right:
        #         if missed[lvl - 1]:
        #             return False
        #
        #     q.append((node.left, lvl + 1))
        #     q.append((node.right, lvl + 1))
        #
        # return True

        #
        # Solution v1.1: BFS
        # Algorithm improvement
        #
        # Runtime: 30 ms @ (beats) 94.47%
        # Memory Usage: 13.9 MB @ (beats) 61.14%
        #
        # q = collections.deque()
        # q.append(root)
        # missed = False
        #
        # while q:
        #     # BFS, iterate same lvl
        #     for _ in range(len(q)):
        #         node = q.popleft()
        #
        #         if not node:
        #             missed = True
        #             continue
        #
        #         if missed:
        #             return False
        #
        #         q.append(node.left)
        #         q.append(node.right)
        #
        # return True

        #
        # Solution v1.5: BFS
        # Combination of previous solution
        #
        # Runtime: 24 ms @ (beats) 100%
        # Memory Usage: 13.7 MB @ (beats) 96.89%
        #
        q = [root]
        missed = False

        while q:
            node = q.pop(0)

            if not node:
                missed = True
                continue

            if missed:
                return False

            q.append(node.left)
            q.append(node.right)

        return True

