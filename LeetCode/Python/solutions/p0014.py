from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        #
        # if not strs:
        #     return ""
        # elif len(strs) == 1:
        #     return strs[0]
        #
        # ans = strs[0]
        #
        # for str in strs:
        #     if len(ans) > len(str):
        #         ans = str
        #
        # i = 0
        #
        # while i < len(strs):
        #     l = len(ans)
        #     if not strs[i][:l].__eq__(ans):
        #         if l > 1:
        #             ans = ans[:l-1]
        #             continue
        #         else:
        #             return ""
        #     i+=1
        #
        # return ans

        if not strs:
            return ""

        candidate = min(strs, key=len)

        for i, ch in enumerate(strs):
            for other in strs:
                if other[i] != ch:
                    return candidate[:i]

        return candidate