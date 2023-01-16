from collections import defaultdict
from typing import List


class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        # class LinkedTree:
        #     def __init__(self, val=0, prev=None, left=None, right=None):
        #         self.val = val
        #         self.prev = prev
        #         self.left = left
        #         self.right = right
        #
        # if n == 1:
        #     return 0
        # elif n == 2:
        #     return 2 if hasApple[1] else 0
        # else:

        #
        # Solution v1: Depth First
        #
        #

        # build a map to reflect node relationship
        path = defaultdict(list)

        for p, c in edges:
            path[p].append(c)
            path[c].append(p)

        def dfs(node, parent):
            steps = 0
            for child in path[node]:
                if child != parent:
                    steps += dfs(child, node)

            # for node 0, there is no cost
            if hasApple[node] and node != 0:
                # if a child node has apple
                # we must count in the steps
                # which is needed to go to and back from its parent node
                hasApple[parent] = True
                return steps + 2

            return steps

        return dfs(0, 0)
