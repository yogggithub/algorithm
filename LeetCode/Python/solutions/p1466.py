from typing import List


class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 1109 ms @ (beats) 99.5%
        # Memory Usage: 61.2 MB @ (beats) 60.38%
        #
        roads = [[] for _ in range(n)]

        for s, e in connections:
            roads[s].append(e)
            roads[e].append(-s)

        visited = [False] * n

        def helper(city):
            nonlocal roads, visited
            ans = 0
            visited[city] = True

            for dest in roads[city]:
                if not visited[abs(dest)]:
                    ans += helper(abs(dest)) + (1 if dest > 0 else 0)
            return ans

        return helper(0)


if __name__ == "__main__":
    solution = Solution()

    n = 6
    connections = [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]
    print(f"return: {solution.minReorder(n, connections)}")  # 3

    n = 5
    connections = [[1, 0], [1, 2], [3, 2], [3, 4]]
    print(f"return: {solution.minReorder(n, connections)}")  # 2

    n = 3
    connections = [[1, 0], [2, 0]]
    print(f"return: {solution.minReorder(n, connections)}")  # 0

    n = 4
    connections = [[0, 1], [2, 0], [3, 2]]
    print(f"return: {solution.minReorder(n, connections)}")  # 1
