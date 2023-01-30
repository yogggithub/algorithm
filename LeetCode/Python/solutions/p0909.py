import collections
import math
from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)

        def label_to_position(label):
            r, c = divmod(label - 1, n)

            # Boustrophedon style
            # revert column within odd rows
            if r % 2 == 0:
                return n - 1 - r, c
            else:
                return n - 1 - r, n - 1 - c

        queue = collections.deque()
        visited = set()

        # start from label 1 with total step 0
        queue.append((1, 0))

        while queue:
            curr, steps = queue.popleft()

            r, c = label_to_position(curr)

            # trap here, take snake/ladder does not count in steps
            # just like blink to the target square
            if board[r][c] != -1:
                curr = board[r][c]

            if curr == n * n:
                return steps

            for next in range(curr + 1, min(curr + 6, n * n) + 1):
                if next not in visited:
                    visited.add(next)
                    queue.append((next, steps + 1))

        return -1


if __name__ == "__main__":
    solution = Solution()

    board = [
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 35, -1, -1, 13, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 15, -1, -1, -1, -1]
    ]
    print(f"{solution.snakesAndLadders(board)}")  # 4

    board = [
        [-1, -1],
        [-1, 3]
    ]
    print(f"{solution.snakesAndLadders(board)}")  # 1
