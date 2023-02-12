import collections
from typing import List


class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        ans = -1
        n = len(grid)

        # Initialize a queue and add all the land cells to the queue.
        land = collections.deque()
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    land.append((i, j))

        # If the queue is empty or contains all the cells in the grid, return -1.
        # This means there are no water cells or all cells are land cells.
        if not land or len(land) == n * n:
            return ans

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while land:
            # every move means distance increment 1
            ans += 1
            for _ in range(len(land)):
                x, y = land.popleft()

                for dx, dy in directions:
                    i = x + dx
                    j = y + dy

                    if 0 <= i < n and 0 <= j < n and grid[i][j] == 0:
                        # mark as visited
                        grid[i][j] = 1

                        land.append((i, j))

        return ans


if __name__ == "__main__":
    solution = Solution()

    grid = [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
    print(f"return: {solution.maxDistance(grid)}")  # 2

    # grid = [[1, 0, 0], [0, 0, 0], [0, 0, 0]]
    # print(f"return: {solution.maxDistance(grid)}")  # 4
