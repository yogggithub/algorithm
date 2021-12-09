class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 32 ms @ (beats) 59.70%
        # Memory Usage: 14.3 MB @ (beats) 36.79%
        #
        s = s.rstrip()
        i = len(s) - 1
        ans = 0
        while i >= 0:
            if s[i] != " ":
                ans += 1
                i -= 1
            else:
                break
        return ans
