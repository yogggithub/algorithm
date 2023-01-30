from collections import defaultdict
from typing import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 821 ms @ (beats) 45.11%
        # Memory Usage: 19.2 MB @ (beats) 8.15%
        #

        # if len(trust) == 0:
        #     return 1 if n == 1 else -1
        #
        # judge = []
        # p = [False] * (n + 1)
        #
        # for a, b in trust:
        #     if not judge:
        #         judge.append(b)
        #
        #     if b not in judge and p[a] and not p[b]:
        #         judge.append(b)
        #
        #     if a in judge:
        #         judge.remove(a)
        #
        #     p[a] = True
        #
        # # print(judge)
        # # print(p)
        #
        # if len(judge) != 1:
        #     return -1
        #
        # return -1 if p[judge[0]] else judge[0]

        #
        # Solution v1.1: Brute Force
        #
        # Runtime: 929 ms @ (beats) 40.93%
        # Memory Usage: 18.9 MB @ (beats) 90.33%
        #

        # judge = [1] * (n + 1)
        #
        # for a, b in trust:
        #     judge[a] = -1
        #
        #     if judge[b] == n:
        #         return b
        #     elif judge[b] > 0:
        #         judge[b] += 1
        #
        # for j in range(1, len(judge)):
        #     if judge[j] == n:
        #         return j
        #
        # return -1

        #
        # Solution v1.5: do not use if in loop
        #
        # Runtime: 929 ms @ (beats) 40.93%
        # Memory Usage: 18.9 MB @ (beats) 90.33%
        #

        people = [0] * (n + 1)
        # event judge trusts himself
        be_trusted = [1] * (n + 1)

        for a, b in trust:
            people[a] += 1
            be_trusted[b] += 1

        # print(people)
        # print(be_trusted)

        for i in range(1, n + 1):
            if people[i] == 0 and be_trusted[i] == n:
                return i

        return -1

        #
        # Solution v1.6: performance improvement
        #
        # Runtime: 779 ms @ (beats) 60.43%
        # Memory Usage: 19 MB @ (beats) 25.51%
        #

        # people = defaultdict(int)
        # be_trusted = defaultdict(int)
        #
        # for a, b in trust:
        #     people[a] += 1
        #     be_trusted[b] += 1
        #
        # # print(people)
        # # print(be_trusted)
        #
        # for i in range(1, n + 1):
        #     if people[i] == 0 and be_trusted[i] == n - 1:
        #         return i
        #
        # return -1


if __name__ == "__main__":
    solution = Solution()

    n = 2
    trust = [[1, 2]]
    print(f"return: {solution.findJudge(n, trust)}")  # 2

    n = 3
    trust = [[1, 3], [2, 3]]
    print(f"return: {solution.findJudge(n, trust)}")  # 3

    n = 3
    trust = [[1, 3], [2, 3], [3, 1]]
    print(f"return: {solution.findJudge(n, trust)}")  # -1

    n = 3
    trust = [[1, 2], [2, 3]]
    print(f"return: {solution.findJudge(n, trust)}")  # -1

    n = 4
    trust = [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]
    print(f"return: {solution.findJudge(n, trust)}")  # 3

    n = 1
    trust = []
    print(f"return: {solution.findJudge(n, trust)}")  # 1

    n = 4
    trust = [[1, 2], [3, 2], [1, 3], [4, 1], [3, 1], [2, 1], [2, 3], [4, 3], [4, 2], [3, 4], [2, 4]]
    print(f"return: {solution.findJudge(n, trust)}")  # -1
