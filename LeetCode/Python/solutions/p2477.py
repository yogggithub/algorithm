import collections
import math
from typing import List


class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        self.ans = 0

        n = len(roads)
        if not n:
            return self.ans

        self.seats = seats
        self.path = [[] for _ in range(n + 1)]
        for s, e in roads:
            self.path[s].append(e)
            self.path[e].append(s)

        self.dfs(-1, 0)

        return self.ans

    def dfs(self, prev, curr):
        passenger = 1

        for nxt in self.path[curr]:
            if nxt == prev:
                continue

            passenger += self.dfs(curr, nxt)

        if curr > 0:
            self.ans += int(math.ceil(passenger / self.seats))

        return passenger


if __name__ == "__main__":
    solution = Solution()

    # roads = [[0, 1], [0, 2], [0, 3]]
    # seats = 5
    # print(f"return: {solution.minimumFuelCost(roads, seats)}")  # 3

    roads = [[3, 1], [3, 2], [1, 0], [0, 4], [0, 5], [4, 6]]
    seats = 2
    print(f"return: {solution.minimumFuelCost(roads, seats)}")  # 7

    # roads = []
    # seats = 0
    # print(f"return: {solution.minimumFuelCost(roads, seats)}")  # 0
