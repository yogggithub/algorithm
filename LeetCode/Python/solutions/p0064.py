from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 96 ms @ (beats) 81.23%
        # Memory Usage: 15.8 MB @ (beats) 46.72%
        #

        m = len(grid)
        n = len(grid[0])

        # accumulate 1st column from top to bottom
        for i in range(1, m):
            grid[i][0] += grid[i - 1][0]

        # accumulate 1st row from left to right
        for j in range(1, n):
            grid[0][j] += grid[0][j - 1]

        # fill up the left cell based on 1st row and 1st col
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i][j - 1], grid[i - 1][j])

        return grid[-1][-1]

        # m, n = len(grid), len(grid[0])
        # print(grid)
        # for i in range(1, m):
        #     grid[i][0] += grid[i - 1][0]
        # print(grid)
        # for i in range(1, n):
        #     grid[0][i] += grid[0][i - 1]
        # print(grid)
        # for i in range(1, m):
        #     for j in range(1, n):
        #         grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        # print(grid)
        # return grid[-1][-1]


if __name__ == "__main__":
    solution = Solution()

    grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    print(f"return: {solution.minPathSum(grid)}")  # 7

    grid = [[1, 2, 3], [4, 5, 6]]
    print(f"return: {solution.minPathSum(grid)}")  # 12
