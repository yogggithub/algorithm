from typing import List


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        # m = len(grid)
        # n = len(grid[0])
        #
        # visited = [[False] * n for _ in range(m)]
        # ans = 0
        # for i in range(m):
        #     for j in range(n):
        #         if visited[i][j] or not grid[i][j]:
        #             continue
        #         visited[i][j] = True
        #         q = [(i, j)]
        #         flag = 1
        #         count = 0
        #         while q:
        #             r, c = q.pop()
        #             neighbor = [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]
        #
        #             for x, y in neighbor:
        #                 if x < 0 or x >= m or y < 0 or y >= n:
        #                     flag = 0
        #                     continue
        #                 if visited[x][y] or not grid[x][y]:
        #                     continue
        #                 visited[x][y] = True
        #                 count += 1
        #                 flag += 1
        #                 print(f"{x} * {y} -> {count}")
        #                 q.append((x, y))
        #
        #         if flag:
        #             print(flag)
        #             ans += count
        #
        # return ans

        #
        # Solution v1: DFS
        # Mark all 1s that connect to edge to 0
        # then simply count all 1s
        #
        # Runtime: 594 ms @ (beats) 97.27%
        # Memory Usage: 75.6 MB @ (beats) 63.84%
        #
        # m = len(grid)
        # n = len(grid[0])
        #
        # def marker(x, y):
        #     nonlocal grid, m, n
        #     if x < 0 or x >= m or y < 0 or y >= n or not grid[x][y]:
        #         return
        #
        #     grid[x][y] = 0
        #
        #     marker(x - 1, y)
        #     marker(x + 1, y)
        #     marker(x, y - 1)
        #     marker(x, y + 1)
        #
        # for i in range(m):
        #     marker(i, 0)
        #     marker(i, n - 1)
        #
        # for j in range(n):
        #     marker(0, j)
        #     marker(m - 1, j)
        #
        # ans = 0
        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j]:
        #             ans += 1
        #
        # return ans

        #
        # Solution v1.1: DFS
        # Count 1s equals to calculate sum
        #
        # Runtime: 631 ms @ (beats) 87.62%
        # Memory Usage: 75.8 MB @ (beats) 56.92%
        #
        m = len(grid)
        n = len(grid[0])

        def marker(x, y):
            nonlocal grid, m, n
            if x < 0 or x >= m or y < 0 or y >= n or not grid[x][y]:
                return

            grid[x][y] = 0

            marker(x - 1, y)
            marker(x + 1, y)
            marker(x, y - 1)
            marker(x, y + 1)

        for i in range(m):
            marker(i, 0)
            marker(i, n - 1)

        for j in range(n):
            marker(0, j)
            marker(m - 1, j)

        return sum(sum(g) for g in grid)


if __name__ == "__main__":
    solution = Solution()

    grid = [[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]
    print(f"return: {solution.numEnclaves(grid)}")  # 3

    grid = [[0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]]
    print(f"return: {solution.numEnclaves(grid)}")  # 0
