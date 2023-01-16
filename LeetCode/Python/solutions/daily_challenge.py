from collections import defaultdict
from typing import Optional, List

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        elif not p or not q:
            return False
        elif p.val != q.val:
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        path = defaultdict(list)

        for s, e in edges:
            path[s].append(e)
            path[e].append(s)

        def func(curr, parent, mx, res):
            for i in path[curr]:
                if vals[curr] > mx:
                    return res
                if i != parent:
                    return func(i, curr, mx, res)

            if vals[curr] == mx:
                res += 1

        ans = len(vals)
        if ans == 1:
            return ans
        elif ans == 2:
            return 2 if vals[0] == vals[1] else 1
        else:
            return func(0, 0, vals[0], ans)


if __name__ == "__main__":
    solution = Solution()

    vals = [1, 3, 2, 1, 3]
    edges = [[0, 1], [0, 2], [2, 3], [2, 4]]
    print(f"return: {solution.numberOfGoodPaths(vals, edges)}")  # 6
