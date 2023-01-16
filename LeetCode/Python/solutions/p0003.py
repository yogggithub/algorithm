from collections import defaultdict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 54 ms @ (beats) 94.95%
        # Memory Usage: 14 MB @ (beats) 92.43%
        #
        if len(s) <= 1:
            return len(s)
        elif len(s) == 2:
            return 1 if s[0] == s[1] else 2
        else:
            flag = {}
            ans = 0
            temp = ""
            start = 0

            for i in range(len(s)):
                if flag.get(s[i]) is not None and flag.get(s[i]) >= start:
                    ans = max(ans, len(temp))
                    start = flag.get(s[i]) + 1
                    idx = temp.find(s[i]) + 1
                    if idx >= len(temp):
                        temp = ""
                    else:
                        temp = temp[idx:]
                    # continue

                temp += s[i]
                flag[s[i]] = i

            return max(ans, len(temp))


if __name__ == "__main__":
    solution = Solution()

    s = "abcabcbb"
    print(f"return: {solution.lengthOfLongestSubstring(s)}")  # 3

    s = "bbbbb"
    print(f"return: {solution.lengthOfLongestSubstring(s)}")  # 1

    s = "pwwkew"
    print(f"return: {solution.lengthOfLongestSubstring(s)}")  # 3

    s = "aab"
    print(f"return: {solution.lengthOfLongestSubstring(s)}")  # 2
