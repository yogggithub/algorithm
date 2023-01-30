from collections import defaultdict
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        ans = 0

        path = defaultdict(dict)
        flag = False

        for s, e, p in flights:
            if e == dst:
                flag = True
            path[s][e] = p

        if flag:
            trip_cost = 0
            start = src
            traveled = 0
            for e, p in path[start].items():
                trip_cost += p
                if e == dst:
                    if ans == 0:
                        ans = trip_cost
                    else:
                        ans = min(ans, trip_cost)
                else:
                    start = e
                    traveled += 1
        else:
            return -1

        return ans

if __name__ == "__main__":
    solution = Solution()

    n = 4
    flights = [
        [0, 1, 100],
        [1, 2, 100],
        [2, 0, 100],
        [1, 3, 600],
        [2, 3, 200]
    ]
    src = 0
    dst = 3
    k = 1
    print(f"return: {solution.findCheapestPrice(n, flights, src, dst, k)}")  # 700

    # n = 3
    # flights = [
    #     [0, 1, 100],
    #     [1, 2, 100],
    #     [0, 2, 500]
    # ]
    # src = 0
    # dst = 2
    # k = 1
    # print(f"return: {solution.findCheapestPrice(n, flights, src, dst, k)}")  # 200
    #
    # n = 3
    # flights = [
    #     [0, 1, 100],
    #     [1, 2, 100],
    #     [0, 2, 500]
    # ]
    # src = 0
    # dst = 2
    # k = 0
    # print(f"return: {solution.findCheapestPrice(n, flights, src, dst, k)}")  # 500
