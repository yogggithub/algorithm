import collections
from typing import List


class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        # {num: indices}
        graph = collections.defaultdict(list)
        steps = 0
        q = collections.deque([0])
        seen = {0}

        # Create graph where keys are elements and values are their indices in arr
        for i, a in enumerate(arr):
            graph[a].append(i)

        # BFS
        while q:
            # Process all nodes at current level
            for _ in range(len(q)):
                i = q.popleft()
                # If last index is reached, return number of steps
                if i == n - 1:
                    return steps
                seen.add(i)
                u = arr[i]
                # Add adjacent indices to graph
                if i + 1 < n:
                    graph[u].append(i + 1)
                if i - 1 >= 0:
                    graph[u].append(i - 1)
                # Process all adjacent nodes
                for v in graph[u]:
                    if v in seen:
                        continue
                    q.append(v)
                # Clear indices in graph to avoid revisiting
                graph[u].clear()
            steps += 1


if __name__ == "__main__":
    solution = Solution()

    arr = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]
    print(f"return: {solution.minJumps(arr)}")  # 3

    # arr = [7]
    # print(f"return: {solution.minJumps(arr)}")  # 0
    #
    # arr = [7, 6, 9, 6, 9, 6, 9, 7]
    # print(f"return: {solution.minJumps(arr)}")  # 1
