import math


class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        temp = 0
        if str1 + str2 == str2 + str1:
            temp = math.gcd(len(str1), len(str2))

        return str1[:temp]


if __name__ == "__main__":
    solution = Solution()

    str1 = "ABCABC"
    str2 = "ABC"
    print(f"return: {solution.gcdOfStrings(str1, str2)}")  # ABC

    str1 = "ABABAB"
    str2 = "ABAB"
    print(f"return: {solution.gcdOfStrings(str1, str2)}")  # AB

    str1 = "LEET"
    str2 = "CODE"
    print(f"return: {solution.gcdOfStrings(str1, str2)}")  #
