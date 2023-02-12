import collections
from collections import defaultdict
from typing import List


class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        ans = [-1] * n
        # structure:
        # {start_point: [(end_point, edge-color), ...]
        graph = defaultdict(list)

        # use 0 indicate blue, and 1 present red
        for s, e in blueEdges:
            graph[s].append((e, 0))
        for s, e in redEdges:
            graph[s].append((e, 1))

        # a queue for traverse through all node
        # the edge for 0 defines as -1 because it can start either blue or red
        q = collections.deque([(0, -1)])

        steps = 0
        while q:
            for _ in range(len(q)):
                # pop an edge from queue
                # here, the node is current position
                # but color is the previous edge, next one must be different
                curr, prev = q.popleft()

                if ans[curr] == -1:
                    ans[curr] = steps

                for i in range(len(graph[curr])):
                    nxt, color = graph[curr][i]

                    if nxt == -1 or color == prev:
                        continue
                    q.append(graph[curr][i])

                    # update current node to -1 indicates
                    # this edge is visited to avoid loop
                    # tuple is non editable, has to replace with a new one
                    graph[curr][i] = (-1, color)
            steps += 1

        return ans


if __name__ == "__main__":
    solution = Solution()

    n = 3
    redEdges = [[0, 1], [1, 2]]
    blueEdges = []
    print(f"return: {solution.shortestAlternatingPaths(n, redEdges, blueEdges)}")  # [0,1,-1]

    n = 3
    redEdges = [[0, 1]]
    blueEdges = [[2, 1]]
    print(f"return: {solution.shortestAlternatingPaths(n, redEdges, blueEdges)}")  # [0,1,-1]
