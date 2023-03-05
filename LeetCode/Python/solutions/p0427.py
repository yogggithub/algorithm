from typing import List

from Python.auxiliary.QuadTree import Node


class Solution:
    def construct(self, grid: List[List[int]]) -> Node:

        #
        # Solution v1: Recursive
        #
        # Runtime: 108 ms @ (beats) 90.36%
        # Memory Usage: 14.7 MB @ (beats) 86.50%
        #
        return self.helper(grid, 0, 0, len(grid))

    def helper(self, grid, i, j, k):
        if self.isLeaf(grid, i, j, k):
            return Node(grid[i][j], True)

        node = Node(True, False)
        node.topLeft = self.helper(grid, i, j, k // 2)
        node.topRight = self.helper(grid, i, j + k // 2, k // 2)
        node.bottomLeft = self.helper(grid, i + k // 2, j, k // 2)
        node.bottomRight = self.helper(grid, i + k // 2, j + k // 2, k // 2)

        return node

    def isLeaf(self, grid, i, j, k):
        for x in range(i, i + k):
            for y in range(j, j + k):
                if grid[x][y] != grid[i][j]:
                    return False

        return True
