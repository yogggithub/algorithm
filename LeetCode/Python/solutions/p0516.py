class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        #
        # Solution v1: dynamic programming and backward
        #
        # Runtime: 1013 ms @ (beats) 87.43%
        # Memory Usage: 13.8 MB @ (beats) 99.94%
        #
        l = len(s)
        dp = [0] * l

        for i in range(l - 1, -1, -1):
            curr = [0] * l
            curr[i] = 1
            for j in range(i + 1, l):
                if s[i] == s[j]:
                    curr[j] = 2 + dp[j - 1]
                else:
                    curr[j] = max(dp[j], curr[j - 1])
            dp = curr

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()

    s = "bbbab"
    print(f"return: {solution.longestPalindromeSubseq(s)}")  # 4

    s = "cbbd"
    print(f"return: {solution.longestPalindromeSubseq(s)}")  # 2
