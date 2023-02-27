import collections
from typing import Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        #
        # Solution v1: Iterative
        #
        # Runtime: 46 ms @ (beats) 54.48%
        # Memory Usage: 15.3 MB @ (beats) 81.3%
        #

        # ans = 0
        # if root:
        #     queue = collections.deque()
        #     queue.append((root, 1))
        #
        #     while queue:
        #         curr, lvl = queue.popleft()
        #
        #         if curr.left:
        #             queue.append((curr.left, lvl + 1))
        #         if curr.right:
        #             queue.append((curr.right, lvl + 1))
        #
        #         ans = max(ans, lvl)
        #
        # return ans

        #
        # Solution v2: Recursive
        #
        # Runtime: 49 ms @ (beats) 36.18%
        # Memory Usage: 16.3 MB @ (beats) 18.14%
        #
        if root:
            return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
        else:
            return 0


if __name__ == "__main__":
    solution = Solution()

    root = [3, 9, 20, None, None, 15, 7]
    print(f"return: {solution.maxDepth(root)}")  # 3

    root = [1, None, 2]
    print(f"return: {solution.maxDepth(root)}")  # 2
