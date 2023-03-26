import collections
from typing import List


class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        #
        # Solution v1: DFS / Union Find
        #
        # Runtime: 2024 ms @ (beats) 95.2%
        # Memory Usage: 75.4 MB @ (beats) 67.26%
        #
        graph = collections.defaultdict(list)

        for x, y in edges:
            graph[x].append(y)
            graph[y].append(x)

        visited = [False] * n

        # if all nodes are isolated,
        # total pairs would be n*(n-1)/2
        ans = n * (n - 1)
        for i in range(n):
            if not visited[i]:
                visited[i] = True
                # count all others connected to current node
                # and decrement answer accordingly
                neighbors = 0
                q = [i]
                while q:
                    neighbors += 1
                    for j in graph[q.pop()]:
                        if not visited[j]:
                            visited[j] = True
                            q.append(j)
                ans -= neighbors * (neighbors - 1)

        # n >> 1 equal to n // 2
        return ans // 2


if __name__ == "__main__":
    solution = Solution()

    n = 3
    edges = [[0, 1], [0, 2], [1, 2]]
    print(f"return: {solution.countPairs(n, edges)}")  # 0

    n = 7
    edges = [[0, 2], [0, 5], [2, 4], [1, 6], [5, 4]]
    print(f"return: {solution.countPairs(n, edges)}")  # 14
