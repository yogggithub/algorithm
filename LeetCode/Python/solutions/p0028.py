class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 130 ms @ (beats) 16.04%
        # Memory Usage: 14.6 MB @ (beats) 33.63%
        #
        # h_len = len(haystack)
        # n_len = len(needle)
        #
        # if n_len == 0:
        #     return 0
        # elif h_len == 0:
        #     return -1
        # elif h_len < n_len:
        #     return -1
        # elif h_len == n_len:
        #     return 0 if haystack == needle else -1
        # else:
        #     for i in range(h_len - n_len + 1):
        #         sub = haystack[i:(i + n_len)]
        #         if sub == needle:
        #             return i
        #
        # return -1

        try:
            h_len = len(haystack)
            n_len = len(needle)
            haystack.index(needle)
        except:
            return -1
