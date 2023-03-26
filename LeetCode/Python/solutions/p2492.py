import collections
from typing import List


class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        #
        # Solution v1: Brute Force
        # iterate through roads, just ignore the param n
        #
        # Runtime: 1642 ms @ (beats) 92.28%
        # Memory Usage: 76.7 MB @ (beats) 31.88%
        #
        ans = float("inf")

        path = collections.defaultdict(dict)
        for s, e, d in roads:
            path[s][e] = d
            path[e][s] = d

        visited = set()
        q = collections.deque()
        q.append(1)

        while q:
            s = q.popleft()
            for e in path[s]:
                if e not in visited:
                    q.append(e)
                    visited.add(e)
                ans = min(ans, path[s][e])

        return ans


if __name__ == "__main__":
    solution = Solution()

    n = 4
    roads = [[1, 2, 9], [2, 3, 6], [2, 4, 5], [1, 4, 7]]
    print(f"return: {solution.minScore(n, roads)}")  # 5

    n = 4
    roads = [[1, 2, 2], [1, 3, 4], [3, 4, 7]]
    print(f"return: {solution.minScore(n, roads)}")  # 2
