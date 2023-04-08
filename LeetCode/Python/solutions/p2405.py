class Solution:
    def partitionString(self, s: str) -> int:
        #
        # Solution v1: Brute Force: Pointer
        #
        # Runtime: 154 ms @ (beats) 34.43%
        # Memory Usage: 14.6 MB @ (beats) 47.10%
        #
        # ans = 1
        # chars = [-1] * 26
        # last = 0
        # for i in range(len(s)):
        #     p = ord(s[i]) - ord('a')
        #     prev = chars[p]
        #
        #     if prev >= last:
        #         ans += 1
        #         last = i
        #
        #     chars[p] = i
        #
        # return ans

        #
        # Solution v2: Brute Force: String
        #
        # Runtime: 86 ms @ (beats) 96.4%
        # Memory Usage: 14.6 MB @ (beats) 47.1%
        #
        ans = 0
        curr = s[0]
        for c in s:
            if c not in curr:
                curr += c
            else:
                ans += 1
                curr = c
        return ans


if __name__ == "__main__":
    solution = Solution()

    s = "abacaba"
    print(f"return: {solution.partitionString(s)}")  # 4

    s = "ssssss"
    print(f"return: {solution.partitionString(s)}")  # 6

    s = "cuieokbs"
    print(f"return: {solution.partitionString(s)}")  # 1
