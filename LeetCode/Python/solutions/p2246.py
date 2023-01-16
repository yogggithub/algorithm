from collections import defaultdict
from typing import List


class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        path = defaultdict(List)

        for i in range(1, len(parent)):
            path[parent[i]].append(i)

        ans = 1

        def dfs(node):
            if node not in path:
                return 1

            temp = 1

            for i in path[node]:
                length = dfs(i)

                if s[node] != s[i]:
                    ans = max(ans, temp + length)
                    temp += max(temp, length + 1)

            return temp

        dfs(0)

        return ans
