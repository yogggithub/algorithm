from typing import List


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 28 ms @ (beats) 86.54%
        # Memory Usage: 13.8 MB @ (beats) 54.52%
        #
        # l = len(needle)
        #
        # for i in range(len(haystack)):
        #     if i + l > len(haystack):
        #         return -1
        #
        #     if haystack[i:i + l] == needle:
        #         return i
        # return -1

        #
        # Solution v1.1: Shorted the codes
        #
        # Runtime: 32 ms @ (beats) 66.81%
        # Memory Usage: 13.8 MB @ (beats) 54.52%
        #
        l = len(needle)

        for i in range(len(haystack) - l + 1):
            if haystack[i:i + l] == needle:
                return i
        return -1


if __name__ == "__main__":
    solution = Solution()

    haystack = "sadbutsad"
    needle = "sad"
    print(f"return: {solution.strStr(haystack, needle)}")  # 0

    haystack = "leetcode"
    needle = "leeto"
    print(f"return: {solution.strStr(haystack, needle)}")  # -1

    haystack = "a"
    needle = "a"
    print(f"return: {solution.strStr(haystack, needle)}")  # 0

    haystack = "abc"
    needle = "c"
    print(f"return: {solution.strStr(haystack, needle)}")  # 2
