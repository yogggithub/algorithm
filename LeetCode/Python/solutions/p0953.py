from collections import defaultdict
from typing import List


class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:

        #
        # Solution v1: Brute Force
        #
        # Runtime: 42 ms @ (beats) 55.42%
        # Memory Usage: 14 MB @ (beats) 31.27%
        #

        alpbet = defaultdict(int)
        alpbet["0"] = 0
        for i in range(len(order)):
            alpbet[order[i]] = i + 1

        for i in range(1, len(words)):
            all_same = True
            for j in range(len(words[i])):
                if j >= len(words[i - 1]):
                    break

                if alpbet[words[i][j]] < alpbet[words[i - 1][j]]:
                    all_same = False
                    return False
                elif alpbet[words[i][j]] > alpbet[words[i - 1][j]]:
                    all_same = False
                    break

            if all_same and len(words[i - 1]) > len(words[i]):
                return False

        return True


if __name__ == "__main__":
    solution = Solution()

    # words = ["hello", "leetcode"]
    # order = "hlabcdefgijkmnopqrstuvwxyz"
    # print(f"return: {solution.isAlienSorted(words, order)}")  # True
    #
    # words = ["word", "world", "row"]
    # order = "worldabcefghijkmnpqstuvxyz"
    # print(f"return: {solution.isAlienSorted(words, order)}")  # False
    #
    # words = ["apple", "app"]
    # order = "abcdefghijklmnopqrstuvwxyz"
    # print(f"return: {solution.isAlienSorted(words, order)}")  # False

    words = ["app", "apple"]
    order = "abcdefghijklmnopqrstuvwxyz"
    print(f"return: {solution.isAlienSorted(words, order)}")  # False
