import collections
from collections import defaultdict
from typing import List


class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        #
        # Solution v1: DFS
        #
        #

        # convert edge to a adjacent dict
        path = defaultdict(list)

        for p, c in edges:
            path[p].append(c)
            path[c].append(p)

        # initialize answer list
        ans = [0] * n

        def dfs(node, parent, cnt):

            # count the same label before go deeper
            before = cnt[labels[node]]

            # recursive
            for child in path[node]:
                if child != parent:
                    dfs(child, node, cnt)

            # increment the same label
            cnt[labels[node]] += 1

            # remove any duplicate amount
            ans[node] = cnt[labels[node]] - before

        dfs(0, 0, collections.Counter())

        return ans
