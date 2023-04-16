class Solution:
    def removeStars(self, s: str) -> str:

        #
        # Solution v1: Brute Force
        #
        # Runtime: 2503 ms @ (beats) 5.7%
        # Memory Usage: 15.3 MB @ (beats) 95.97%
        #
        # star = "*"
        # if not s:
        #     return ""
        #
        # if len(s) == 1:
        #     return "" if s[0] == star else s
        #
        # p = 0
        # i = 0
        # count = 0
        # prev = False
        # # consective = False
        # while i < len(s):
        #     if s[i] == star:
        #         count += 1
        #         i += 1
        #         continue
        #
        #     if count > 0:
        #         left = max(0, i - count * 2)
        #         s = s[:left] + s[i:]
        #         # print(s)
        #         i = left
        #         count = 0
        #     else:
        #         i += 1
        #
        # if count:
        #     s = s[:max(0, i - count * 2)]
        #
        # return s

        #
        # Solution v1.1: Brute Force
        #
        # Runtime: 498 ms @ (beats) 12.67%
        # Memory Usage: 15.4 MB @ (beats) 93.9%
        #
        # star = "*"
        # ans = ""
        # count = 0
        #
        # for c in s:
        #     if c == star:
        #         count += 1
        #         continue
        #
        #     if count > 0:
        #         ans = ans[:max(0, len(ans) - count)]
        #         count = 0
        #
        #     ans += c
        #
        # if count > 0:
        #     ans = ans[:max(0, len(ans) - count)]
        #
        # return ans

        #
        # Solution v2: Stack
        #
        # Runtime: 211 ms @ (beats) 96.66%
        # Memory Usage: 15.6 MB @ (beats) 77.42%
        #

        # ans = []
        #
        # for c in s:
        #     if c == "*":
        #         ans.pop()
        #         continue
        #     ans.append(c)
        #
        # return "".join(ans)

        #
        # Solution v3: Pointer & Backward
        #
        # Runtime: 301 ms @ (beats) 32.14%
        # Memory Usage: 16.4 MB @ (beats) 6.45%
        #
        ans = []
        l = len(s)
        count = 0
        for i in range(l - 1, -1, -1):
            if s[i] == "*":
                count += 1
            else:
                if count > 0:
                    count -= 1
                else:
                    ans.append(s[i])
        return "".join(reversed(ans))


if __name__ == "__main__":
    solution = Solution()

    s = "leet**cod*e"
    print(f"return: {solution.removeStars(s)}")  # "lecoe"

    s = "erase*****"
    print(f"return: {solution.removeStars(s)}")  # ""

    s = ""
    print(f"return: {solution.removeStars(s)}")  # ""
