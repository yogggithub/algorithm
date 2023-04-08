import collections
from typing import List


class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        #
        # Solution v1: DFS
        #
        # Runtime: 124 ms @ (beats) 81.35%
        # Memory Usage: 14.5 MB @ (beats) 61.65%
        #
        # m = len(grid)
        # n = len(grid[0])
        #
        # def marker(x, y):
        #     nonlocal grid, m, n
        #     if x < 0 or x >= m or y < 0 or y >= n or grid[x][y]:
        #         return
        #     # mark current grid as visited
        #     grid[x][y] = 1
        #
        #     # recursive on neighbor grid
        #     # coz they are connected so definitely not closed
        #     marker(x - 1, y)
        #     marker(x + 1, y)
        #     marker(x, y - 1)
        #     marker(x, y + 1)
        #
        # # change all edge grid to 1 coz they are not closed
        # for i in range(m):
        #     marker(i, 0)
        #     marker(i, n - 1)
        #
        # for j in range(n):
        #     marker(0, j)
        #     marker(m - 1, j)
        #
        # print(grid)
        #
        # ans = 0
        # for i in range(m):
        #     for j in range(n):
        #         if not grid[i][j]:
        #             # mark all connected grids to visited
        #             marker(i, j)
        #             print(grid)
        #             ans += 1
        #
        # return ans

        #
        # Solution v2: Brute Force
        #
        # Runtime: 119 ms @ (beats) 92.79%
        # Memory Usage: 14.2 MB @ (beats) 99.60%
        #
        m = len(grid)
        n = len(grid[0])

        ans = 0
        # visited = [[False] * n] * m
        visited = [[False] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if visited[i][j] or grid[i][j]:
                    continue

                island = 1

                visited[i][j] = True

                q = [(i, j)]
                while q:
                    r, c = q.pop()
                    neighbor = [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]
                    for x, y in neighbor:
                        if x < 0 or x >= m or y < 0 or y >= n:
                            island = 0
                            continue
                        if visited[x][y] or grid[x][y]:
                            continue
                        visited[x][y] = True
                        q.append((x, y))

                ans += island

        return ans


if __name__ == "__main__":
    solution = Solution()

    # grid = [[1, 1, 1, 1, 1, 1, 1, 0],
    #         [1, 0, 0, 0, 0, 1, 1, 0],
    #         [1, 0, 1, 0, 1, 1, 1, 0],
    #         [1, 0, 0, 0, 0, 1, 0, 1],
    #         [1, 1, 1, 1, 1, 1, 1, 0]]
    # print(f"return: {solution.closedIsland(grid)}")  # 2
    #
    grid = [[0, 0, 1, 0, 0],
            [0, 1, 0, 1, 0],
            [0, 1, 1, 1, 0]]
    print(f"return: {solution.closedIsland(grid)}")  # 1

    # grid = [[1, 1, 1, 1, 1, 1, 1],
    #         [1, 0, 0, 0, 0, 0, 1],
    #         [1, 0, 1, 1, 1, 0, 1],
    #         [1, 0, 1, 0, 1, 0, 1],
    #         [1, 0, 1, 1, 1, 0, 1],
    #         [1, 0, 0, 0, 0, 0, 1],
    #         [1, 1, 1, 1, 1, 1, 1]]
    # print(f"return: {solution.closedIsland(grid)}")  # 2

