from collections import defaultdict
from typing import List


class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        root = [i for i in range(123)]

        def get(x):
            if x == root[x]:
                return root[x]
            else:
                return get(root[x])

        def link(x, y):
            x = get(x)
            y = get(y)
            if x != y:
                if x < y:
                    root[y] = x
                else:
                    root[x] = y

        for i in range(len(s1)):
            link(ord(s1[i]), ord(s2[i]))

        ans = ""
        for c in baseStr:
            ans += chr(get(ord(c)))

        return ans


if __name__ == "__main__":
    solution = Solution()

    # s1 = "parker"
    # s2 = "morris"
    # baseStr = "parser"
    # print(f"return: {solution.smallestEquivalentString(s1, s2, baseStr)}")  # makkek
    #
    # s1 = "hello"
    # s2 = "world"
    # baseStr = "hold"
    # print(f"return: {solution.smallestEquivalentString(s1, s2, baseStr)}")  # hdld

    s1 = "leetcode"
    s2 = "programs"
    baseStr = "sourcecode"
    print(f"return: {solution.smallestEquivalentString(s1, s2, baseStr)}")  # aauaaaaada
